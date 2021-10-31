from django.urls import path
from . import views

app_name = 'articles'

urlpatterns = [
    path('', views.index, name='index'),
    path('create/', views.create, name='create'),
    # <값정의:변수명>
    path('<int:pk>/', views.detail, name='detail'),
]
