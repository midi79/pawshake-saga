import requests
import time

# URL for the POST request
#url = "http://localhost:8081/api/v1/user/pay"
url = "http://localhost:8081/api/v1/user/choreography/pay"

# Number of POST requests to send
num_requests = 1000

# Time interval between requests (in seconds)
request_interval = 0.5

# Function to send a POST request
def send_post_request():
    try:
        response = requests.post(url)
        # You can add any additional processing for the response here if needed.
    except requests.exceptions.RequestException as e:
        print(f"Request failed: {e}")

# Record the start time
start_time = time.time()

# Send 100 POST requests with a time interval
for _ in range(num_requests):
    send_post_request()
    #time.sleep(request_interval)

# Record the end time
end_time = time.time()

# Calculate and output the execution time
execution_time = end_time - start_time
print(f"Total execution time: {execution_time:.2f} seconds")