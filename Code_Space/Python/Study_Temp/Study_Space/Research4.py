import tkinter as tk
from tkinter import filedialog
from tkinter import messagebox
from PIL import Image, ImageTk


class ImageProcessor:
    def __init__(self, tmp_root):
        self.root = tmp_root
        self.root.title("图片处理程序")
        root.geometry("800x800")

        self.image_label = tk.Label(self.root)
        self.image_label.pack()

        self.load_button = tk.Button(self.root, text="加载图片", command=self.load_image)
        self.load_button.pack()

        self.gray_button = tk.Button(self.root, text="灰度化", command=self.convert_to_gray)
        self.gray_button.pack()

        self.restore_button = tk.Button(self.root, text="恢复原图", command=self.restore_original)
        self.restore_button.pack()

        self.scale_label = tk.Label(self.root, text="缩放比例 (0.1-2.0):")
        self.scale_label.pack()
        self.scale_entry = tk.Entry(self.root)
        self.scale_entry.pack()

        self.scale_button = tk.Button(self.root, text="缩放", command=self.scale_image)
        self.scale_button.pack()

        self.rotate_label = tk.Label(self.root, text="旋转角度 (0-360):")
        self.rotate_label.pack()
        self.rotate_entry = tk.Entry(self.root)
        self.rotate_entry.pack()

        self.rotate_button = tk.Button(self.root, text="旋转", command=self.rotate_image)
        self.rotate_button.pack()

        self.save_label = tk.Label(self.root, text="保存文件名:")
        self.save_label.pack()
        self.save_entry = tk.Entry(self.root)
        self.save_entry.pack()

        self.save_button = tk.Button(self.root, text="保存图片", command=self.save_image)
        self.save_button.pack()

        self.original_image = None
        self.image = None

    def load_image(self):
        file_path = filedialog.askopenfilename()
        if file_path:
            self.image = Image.open(file_path)
            self.original_image = self.image.copy()
            self.display_image()

    def display_image(self):
        if self.image:
            photo = ImageTk.PhotoImage(self.image)
            self.image_label.config(image=photo)
            self.image_label.image = photo

    def convert_to_gray(self):
        if self.image:
            self.image = self.image.convert("L")
            self.display_image()

    def restore_original(self):
        if self.original_image:
            self.image = self.original_image.copy()
            self.display_image()

    def scale_image(self):
        if self.image:
            scale = self.scale_entry.get()
            try:
                scale = float(scale)
                self.image = self.image.resize((int(self.image.width * scale), int(self.image.height * scale)))
                self.display_image()
            except ValueError:
                messagebox.showerror("错误", "请输入有效的缩放比例 (0.1-2.0)")

    def rotate_image(self):
        if self.image:
            angle = self.rotate_entry.get()
            try:
                angle = float(angle)
                self.image = self.image.rotate(angle)
                self.display_image()
            except ValueError:
                messagebox.showerror("错误", "请输入有效的旋转角度 (0-360)")

    def save_image(self):
        if self.image:
            save_path = "C://Users/小吴同志的R7000P/Pictures/Saved Pictures/" + self.save_entry.get() + ".png"
            if save_path:
                self.image.save(save_path)
                messagebox.showinfo("保存成功", f"图片已保存为 {save_path}")


if __name__ == "__main__":
    root = tk.Tk()
    app = ImageProcessor(root)
    root.mainloop()
