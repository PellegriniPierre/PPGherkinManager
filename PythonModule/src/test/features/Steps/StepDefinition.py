from behave import *
from selenium import webdriver
from selenium.webdriver.common.by import By


@given("I am at the login page as an user or admin/superAdmin role")
def step_impl(context):
    context.driver = webdriver.Chrome()
    context.get(context.get_url("http://20.13.162.105:8000/"))
    context.driver.find_element(By.CLASS_NAME,"button wp-element-button product_type_simple add_to_cart_button ajax_add_to_cart").click()
