LinkedIn Designer Scraper <br>
This is a mini Selenium automation project that logs into LinkedIn, searches for profiles with the keyword "Hospital", scrapes names, and saves them to a CSV file.

🚀 Features
Automated login to LinkedIn
Searches for "Hospital" keyword
Scrapes names of people in search results
Saves results to designer_search_results.csv

🛠 Tech Stack
Java
Selenium WebDriver
ChromeDriver
🔐 How to Run
You must have Java and Selenium WebDriver installed to run this code.

Set your LinkedIn credentials as environment variables:

LINKEDIN_EMAIL
LINKEDIN_PASSWORD
Place chromedriver.exe in a folder named drivers

Run using your IDE or terminal:

javac LinkedinSearch.java
java LinkedinSearch
📂 Output
designer_search_results.csv — List of profile names
⚠️ This project is for educational purposes only.
