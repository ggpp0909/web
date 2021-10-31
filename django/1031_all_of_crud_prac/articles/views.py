from django.shortcuts import get_object_or_404, redirect, render
from django.views.decorators.http import require_safe
from .models import Article
from .forms import ArticleForm

# Create your views here.
#get요청일때만
@require_safe
def index(request):
    # 모든 게시물들을 보여줄 것
    articles = Article.objects.order_by('-pk')
    context = {
        'articles': articles
    }
    # render 함수를 2번째 인자 문자열 경로는 실제 파일이 저장되어 있는 경로를 의미,templates는 생략
    return render(request, 'articles/index.html', context)

def create(request):
    if request.method == 'POST':
        form = ArticleForm(request.POST, request.FILES)
        if form.is_valid():
            form.save()
            return redirect('articles:index')
    else:
        form = ArticleForm()
    context = {
        'form': form
    }
    return render(request, 'articles/create.html', context)

def detail(request, pk):
    article = get_object_or_404(Article, pk=pk)
    context = {
        'article': article
    }
    return render(request, 'articles/detail.html', context)