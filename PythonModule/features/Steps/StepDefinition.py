from behave import *
from selenium import webdriver
from selenium.webdriver.common.by import By


@given('I do a {string} request to API')
def step_impl(arg0, string):
    if arg0 == 'get':
        'il se passe rien'
    if arg0 == 'post':
        'il se passe rien non plus'

@given("I check elements on the frontend")
def step_impl(context):
    context.driver = webdriver.Chrome()
    context.get(context.get_url("http://20.13.162.105:8000/"))
    context.driver.find_element(By.CLASS_NAME,"Cet element existe pas").click()


@given("I launch a db request")
def step_impl(context):
    'Est ce que c\'est vraiment un test ce truc??'