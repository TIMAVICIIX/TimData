from django.contrib import admin

from .models import BoardMessage
# 为后台管理注册BoardMessage
admin.site.register(BoardMessage)
