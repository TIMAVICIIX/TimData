import tkinter as tk

# 创建主窗口
root = tk.Tk()

# 设置窗口title
root.title("第二次作业")

# 设置窗口大小
root.geometry("650x400")

# 改变背景颜色
root.configure(bg="#3232CD")

# 设置窗口处于顶层
root.lift()

# 设置窗口的透明度
root.attributes('-alpha', 0.9)

# 设置窗口被允许最大调整的范围
root.maxsize(800, 600)

# 设置窗口被允许最小调整的范围
root.minsize(400, 300)

# 将ICO图标设置为窗口图标
root.iconbitmap("C:/Users/小吴同志的R7000P/Pictures/Saved Pictures/output_icon.ico")  # 替换为生成的ICO文件路径

# 添加文本内容并设置字体格式
text_label = tk.Label(root, text="谁家玉笛暗飞声", font=("Arial", 16, "bold"), bg="#3232CD", fg="white")
text_label.pack()


# 添加按钮并设置关闭窗口的功能
def close_window():
    root.destroy()


button = tk.Button(root, text="关闭窗口", command=close_window)
button.pack()

# 进入主循环
root.mainloop()
