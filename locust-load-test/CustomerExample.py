import json

from locust import HttpUser, task, between

from RequestDTO import CreateCustomerRequest


class CustomerExample(HttpUser):
    wait_time = between(5, 9)

    @task
    def customer_list(self):
        response = self.client.get("/customers")
        return response

    @task
    def create_customer(self):
        body = CreateCustomerRequest(name="user1", email="user1@example.com")

        self.client.post("/customer", data=json.dumps(body.__dict__), headers={"content-type": "application/json"})