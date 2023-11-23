import tkinter as tk
from tkinter import ttk, messagebox
from datetime import datetime, timedelta


# 1. 万年历功能
def show_calendar():
    year = int(year_entry.get())
    month = int(month_entry.get())

    # 计算该月的第一天
    first_day = datetime(year, month, 1)

    # 计算该月的天数
    if month == 12:
        next_month = datetime(year + 1, 1, 1)
    else:
        next_month = datetime(year, month + 1, 1)
    num_days = (next_month - first_day).days

    # 创建一个新的窗口用于显示日历
    calendar_window = tk.Toplevel(root)
    calendar_window.title(f"{year}年{month}月日历")

    # 显示星期
    for col, day in enumerate(['日', '一', '二', '三', '四', '五', '六']):
        day_label = tk.Label(calendar_window, text=day)
        day_label.grid(row=0, column=col)

    # 填充日期
    row = 1
    col = first_day.weekday()
    for day in range(1, num_days + 1):
        day_label = tk.Label(calendar_window, text=str(day))
        day_label.grid(row=row, column=col)
        col = (col + 1) % 7
        if col == 0:
            row += 1


# 2. 倒计时功能
def start_countdown():
    target_date_str = target_date_entry.get()
    try:
        target_date = datetime.strptime(target_date_str, '%Y-%m-%d %H:%M:%S')
        now = datetime.now()
        remaining_time = target_date - now
        if remaining_time.total_seconds() > 0:
            days = remaining_time.days
            seconds = remaining_time.seconds
            hours, seconds = divmod(seconds, 3600)
            minutes, seconds = divmod(seconds, 60)
            countdown_label.config(text=f"剩余时间: {days}天 {hours}小时 {minutes}分钟 {seconds}秒")
            root.after(1000, start_countdown)
        else:
            countdown_label.config(text="倒计时结束！")
            messagebox.showinfo("提醒", "倒计时结束！")
    except ValueError:
        messagebox.showerror("错误", "无效的日期时间格式")


# 3. 日期和时间输入及准确性检查
def check_datetime():
    selected_year = year_var.get()
    selected_month = month_var.get()
    selected_day = day_var.get()
    selected_hour = hour_var.get()
    selected_minute = minute_var.get()

    try:
        input_datetime = datetime(selected_year, selected_month, selected_day, selected_hour, selected_minute)
        current_datetime = datetime.now().replace(second=0, microsecond=0)
        if input_datetime == current_datetime:
            result_label.config(text="输入日期和时间与当前时间相同")
        else:
            result_label.config(text="输入日期和时间与当前时间不同")
    except ValueError:
        result_label.config(text="无效的日期或时间")
        messagebox.showerror("错误", "无效的日期或时间")



# 创建主窗口
root = tk.Tk()
root.title("日期和时间工具")

# 1. 万年历功能
calendar_frame = tk.Frame(root)
calendar_frame.pack(pady=20)
year_label = tk.Label(calendar_frame, text="年份:")
year_label.grid(row=0, column=0)
year_entry = tk.Entry(calendar_frame)
year_entry.grid(row=0, column=1)
month_label = tk.Label(calendar_frame, text="月份:")
month_label.grid(row=1, column=0)
month_entry = tk.Entry(calendar_frame)
month_entry.grid(row=1, column=1)
show_calendar_button = tk.Button(calendar_frame, text="显示日历", command=show_calendar)
show_calendar_button.grid(row=2, column=1)

# 2. 倒计时功能
countdown_frame = tk.Frame(root)
countdown_frame.pack(pady=10)
target_date_label = tk.Label(countdown_frame, text="目标日期和时间 (YYYY-MM-DD HH:MM:SS):")
target_date_label.grid(row=0, column=0)
target_date_entry = tk.Entry(countdown_frame)
target_date_entry.grid(row=1, column=0)
start_countdown_button = tk.Button(countdown_frame, text="开始倒计时", command=start_countdown)
start_countdown_button.grid(row=2, column=0)
countdown_label = tk.Label(countdown_frame, text="")
countdown_label.grid(row=3, columnspan=3)
countdown_hint_label = tk.Label(countdown_frame, text="(示例: 2023-10-31 12:00:00)")
countdown_hint_label.grid(row=4, columnspan=3)

# 3. 日期和时间输入及准确性检查
check_datetime_frame = tk.Frame(root)
check_datetime_frame.pack(pady=10)

# 年份选项
year_label = tk.Label(check_datetime_frame, text="年份:")
year_label.grid(row=0, column=0)
year_var = tk.IntVar()
year_var.set(datetime.now().year)  # 默认为当前年份
year_option = ttk.Combobox(check_datetime_frame, textvariable=year_var, values=list(range(1900, 2101)))
year_option.grid(row=0, column=1)
year_option.config(width=4)

# 月份选项
month_label = tk.Label(check_datetime_frame, text="月份:")
month_label.grid(row=0, column=2)
month_var = tk.IntVar()
month_var.set(datetime.now().month)  # 默认为当前月份
month_option = ttk.Combobox(check_datetime_frame, textvariable=month_var, values=list(range(1, 13)))
month_option.grid(row=0, column=3)
month_option.config(width=2)

# 日期选项
day_label = tk.Label(check_datetime_frame, text="日期:")
day_label.grid(row=0, column=4)
day_var = tk.IntVar()
day_var.set(datetime.now().day)  # 默认为当前日期
day_option = ttk.Combobox(check_datetime_frame, textvariable=day_var, values=list(range(1, 32)))
day_option.grid(row=0, column=5)
day_option.config(width=2)

# 小时选项
hour_label = tk.Label(check_datetime_frame, text="小时:")
hour_label.grid(row=0, column=6)
hour_var = tk.IntVar()
hour_var.set(datetime.now().hour)  # 默认为当前小时
hour_option = ttk.Combobox(check_datetime_frame, textvariable=hour_var, values=list(range(0, 24)))
hour_option.grid(row=0, column=7)
hour_option.config(width=2)

# 分钟选项
minute_label = tk.Label(check_datetime_frame, text="分钟:")
minute_label.grid(row=0, column=8)
minute_var = tk.IntVar()
minute_var.set(datetime.now().minute)  # 默认为当前分钟
minute_option = ttk.Combobox(check_datetime_frame, textvariable=minute_var, values=list(range(0, 60)))
minute_option.grid(row=0, column=9)
minute_option.config(width=2)

check_button = tk.Button(check_datetime_frame, text="检查日期和时间", command=check_datetime)
check_button.grid(row=1, column=0, columnspan=10)
result_label = tk.Label(check_datetime_frame, text="")
result_label.grid(row=2, column=0, columnspan=10)

root.mainloop()
