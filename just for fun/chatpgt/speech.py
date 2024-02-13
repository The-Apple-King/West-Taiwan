import speech_recognition as sr
import pyttsx3

r = sr.Recognizer()

def SpeakText(command):
    engine = pyttsx3.init()
    engine.say(command)
    engine.runAndWait()

SpeakText('hello world')

with sr.Microphone() as source2:
    r.adjust_for_ambient_noise(source2, duration=2)
    print("start")
    audio2 = r.listen(source2)
    MyText = r.recognize_google(audio2)
    MyText = MyText.lower()

    SpeakText(MyText)