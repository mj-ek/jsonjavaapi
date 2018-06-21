
import requests
url = "http://personal.ekagga.com/GenericAppBeta/generic/api/getNewsCategory?news_language=English&categoryClientUniqId=theNews_uniq_id"
r = requests.get(url)
print r.json()