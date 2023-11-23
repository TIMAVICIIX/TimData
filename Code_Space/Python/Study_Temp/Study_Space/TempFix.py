import openpyxl

# 打开Excel文件
workbook = openpyxl.load_workbook('C://Users/小吴同志的R7000P/Desktop/WorkSpace.xlsx')

# 选择要操作的工作表
sheet = workbook.active  # 或者使用 sheet = workbook['Sheet1'] 来选择特定的工作表

# 获取第5列的数据
column_5 = sheet['E']  # E表示第5列，根据你的Excel文件可以调整

# 遍历列中的每个单元格，将数据转换为数字，然后转换为文本格式并在个位数前添加0
for cell in column_5:
    if cell.value is not None:
        try:
            value = int(cell.value)
            cell.value = str(value).zfill(2)
        except ValueError:
            # 如果数据无法转换为整数，跳过
            pass

# 保存修改后的Excel文件
workbook.save('C://Users/小吴同志的R7000P/Desktop/WorkSpace.xlsx')

# 关闭Excel文件
workbook.close()
