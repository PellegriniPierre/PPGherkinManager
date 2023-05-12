import mysql.connector
from behave import *
from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager


@given('I do a {string} request to API')
def step_impl(arg0, string):
    if arg0 == 'get':
        'il se passe rien'
    if arg0 == 'post':
        'il se passe rien non plus'


@given("I check elements on the frontend")
def step_impl(context):
    context.driver = webdriver.Chrome(ChromeDriverManager().install())
    context.driver.maximize_window()
    context.driver.get("http://20.13.162.105:8000/")
    clickSurMenuItem = context.driver.find_element(By.XPATH, '//*[@id="menu-item-19"]/a').click()
    clickSurMenuItem
    context.driver.find_element(By.ID, 'menu-item-19').click()
    header = context.driver.find_element(By.CSS_SELECTOR, '#main > header > h1')
    print(header.text)
    assert header.text == "Boutique"


@given("I launch a db request")
def step_impl(context):
    'Est ce que c\'est vraiment un test ce truc??'
    global result, cursor, connection
    try:
        connection = mysql.connector.connect(host='http://localhost:3306', database='wordpress', user='toto',
                                             password='wrongpassword')
        cursor = connection.cursor()
        mysql_query = """SELECT * FROM MATABLE"""
        result = cursor.execute(mysql_query)
        print("il fait beau aujourd'hui " + result)
    except mysql.connector.Error as error:
        print("Impossible de lancer la requete sql")
    finally:
        if connection.is_connected():
            return result
            cursor.close()
            connection.close()
            print("La connexion est bien close")
