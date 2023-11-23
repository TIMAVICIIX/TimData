import tkinter as tk


class MouseCoordinateApp:
    def __init__(self, root_in):
        self.root = root_in
        self.root.title("第八次作业")
        self.root.geometry("600x600+300+350")  # 设置窗口大小和位置

        self.frame = tk.Frame(self.root, width=300, height=300, bg="lightblue")  # 创建frame
        self.frame.pack(padx=50, pady=50)  # 设置frame的边距

        self.x_label = tk.Label(self.root, text="X坐标:", font=("Arial", 12))
        self.y_label = tk.Label(self.root, text="Y坐标:", font=("Arial", 12))
        self.x_label.pack()
        self.y_label.pack()

        self.frame.bind("<Motion>", self.show_coordinates)  # 绑定鼠标移动事件

    def show_coordinates(self, event):
        x, y = event.x, event.y
        self.x_label.config(text=f"X坐标: {x}")
        self.y_label.config(text=f"Y坐标: {y}")


if __name__ == "__main__":
    root = tk.Tk()
    app = MouseCoordinateApp(root)
    root.mainloop()
