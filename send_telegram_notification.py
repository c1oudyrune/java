import os
import requests

TOKEN = os.getenv("TELEGRAM_BOT_TOKEN")
CHAT_ID = os.getenv("TELEGRAM_CHAT_ID")
MESSAGE = os.getenv("MESSAGE")

def send_message():
    url = f"https://api.telegram.org/bot{8689239947:AAHbClkp-RpQUdVFXgtlFXtkZE_cv3QEAps}/sendMessage"
    payload = {
        'chat_id': CHAT_ID,
        'text': MESSAGE
    }
    response = requests.post(url, data=payload)
    if response.status_code != 200:
        print("Ошибка при отправке сообщения:", response.text)
    else:
        print("Сообщение успешно отправлено!")

if __name__ == "__main__":
    send_message()
