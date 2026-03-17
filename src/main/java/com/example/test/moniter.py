import psutil
import time
from datetime import datetime

# ===== 配置区 =====
CPU_THRESHOLD = 80      # CPU 使用率阈值（%）
MEM_THRESHOLD = 80      # 内存使用率阈值（%）
DISK_THRESHOLD = 85     # 磁盘使用率阈值（%）
INTERVAL = 5            # 监控间隔（秒）

def get_disk_usage():
    disk = psutil.disk_usage('/')
    return disk.percent

def monitor():
    while True:
        now = datetime.now().strftime("%Y-%m-%d %H:%M:%S")

        cpu = psutil.cpu_percent(interval=1)
        mem = psutil.virtual_memory().percent
        disk = get_disk_usage()

        print(f"[{now}] CPU: {cpu}% | 内存: {mem}% | 磁盘: {disk}%")

        # 报警判断
        if cpu > CPU_THRESHOLD:
            print("⚠️ CPU 使用率过高！")

        if mem > MEM_THRESHOLD:
            print("⚠️ 内存使用率过高！")

        if disk > DISK_THRESHOLD:
            print("⚠️ 磁盘使用率过高！")

        print("-" * 50)
        time.sleep(INTERVAL)

if __name__ == "__main__":
    monitor()
