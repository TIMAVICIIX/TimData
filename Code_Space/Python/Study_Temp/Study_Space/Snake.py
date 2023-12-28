import pygame
import sys
import random

# 初始化pygame
pygame.init()

# 游戏窗口设置
width, height = 600, 400
win = pygame.display.set_mode((width, height))
pygame.display.set_caption("Snake Game")

# 颜色定义
white = (255, 255, 255)
black = (0, 0, 0)
red = (255, 0, 0)
green = (0, 255, 0)

# 蛇的初始位置和速度
snake_pos = [100, 50]
snake_body = [[100, 50], [90, 50], [80, 50]]
snake_dir = 'RIGHT'
change_to = snake_dir
speed = 10  # 初始速度

# 食物的初始位置
food_pos = [random.randrange(1, (width//10)) * 10,
            random.randrange(1, (height//10)) * 10]

food_spawn = True

# 游戏主循环
while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
        elif event.type == pygame.KEYDOWN:
            if event.key == pygame.K_UP:
                change_to = 'UP'
            elif event.key == pygame.K_DOWN:
                change_to = 'DOWN'
            elif event.key == pygame.K_LEFT:
                change_to = 'LEFT'
            elif event.key == pygame.K_RIGHT:
                change_to = 'RIGHT'

    # 根据按键更新蛇的方向
    if change_to == 'UP' and not snake_dir == 'DOWN':
        snake_dir = 'UP'
    if change_to == 'DOWN' and not snake_dir == 'UP':
        snake_dir = 'DOWN'
    if change_to == 'LEFT' and not snake_dir == 'RIGHT':
        snake_dir = 'LEFT'
    if change_to == 'RIGHT' and not snake_dir == 'LEFT':
        snake_dir = 'RIGHT'

    # 根据方向更新蛇的位置
    if snake_dir == 'UP':
        snake_pos[1] -= 10
    if snake_dir == 'DOWN':
        snake_pos[1] += 10
    if snake_dir == 'LEFT':
        snake_pos[0] -= 10
    if snake_dir == 'RIGHT':
        snake_pos[0] += 10

    # 增加蛇的长度
    snake_body.insert(0, list(snake_pos))
    if snake_pos[0] == food_pos[0] and snake_pos[1] == food_pos[1]:
        food_spawn = False
        speed += 1  # 每吃到食物速度增加1
    else:
        snake_body.pop()

    # 生成新的食物
    if not food_spawn:
        food_pos = [random.randrange(1, (width//10)) * 10,
                    random.randrange(1, (height//10)) * 10]
        food_spawn = True

    # 游戏结束条件
    if snake_pos[0] < 0 or snake_pos[0] > width-10 or snake_pos[1] < 0 or snake_pos[1] > height-10:
        pygame.quit()
        sys.exit()

    # 渲染窗口背景
    win.fill(black)

    # 渲染蛇
    for pos in snake_body:
        pygame.draw.rect(win, green, pygame.Rect(pos[0], pos[1], 10, 10))

    # 渲染食物
    pygame.draw.rect(win, red, pygame.Rect(food_pos[0], food_pos[1], 10, 10))

    # 刷新显示
    pygame.display.flip()

    # 控制游戏速度
    pygame.time.Clock().tick(speed)
