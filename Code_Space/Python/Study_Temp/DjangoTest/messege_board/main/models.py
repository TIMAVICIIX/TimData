from django.db import models


# 创建留言板数据Model
class BoardMessage(models.Model):
    nickname = models.CharField(max_length=10)
    message_text = models.CharField(max_length=200)
    pub_date = models.DateTimeField('date published')
