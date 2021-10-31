from django import forms
from .models import Article

# Form에는 두가지 종류가 있는데, Model에 대한 정보의 유/무 를 기준으로 나눈다.
class ArticleForm(forms.ModelForm):

    class Meta:
        model = Article
        fields = ('title', 'content', 'image',)