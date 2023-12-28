from django.http import HttpResponse
# 引入loader模块
from django.template import loader
from .models import BoardMessage


#
# def index(request):
#     bm = BoardMessage.objects.order_by('-pub_date')[:5]
#     r = ''
#     # 构建字符串
#     for i in bm:
#         r = r + "发布时间：" + str(i.pub_date) + i.nickname + ':' + i.message_text
#     return HttpResponse(r)
def index(request):
    result = BoardMessage.objects.order_by('-pub_date')[:5]
    template = loader.get_template('index.html')
    context = {
        'mbs': result,
    }
    return HttpResponse(template.render(context, request))
