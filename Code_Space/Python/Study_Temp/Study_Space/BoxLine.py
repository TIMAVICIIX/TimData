import matplotlib.pyplot as plt

data = [58, 61, 67, 70, 71, 75, 75, 75, 76, 77, 78, 79, 79, 80, 80, 81, 82, 84, 88, 95]

# 绘制箱线图
plt.boxplot(data)
plt.title('Box Plot of Data')
plt.show()
