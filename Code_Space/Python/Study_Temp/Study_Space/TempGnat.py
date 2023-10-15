# soup = BeautifulSoup(response.text, 'html.parser')
# university_links = soup.find_all('a', href=True)
#
# for link in university_links:
#     university_url = link['href']
#     # Debug
#     print(university_url.text)
#     university_response = requests.get(university_url)
#     university_soup = BeautifulSoup(university_response.text, 'html,parser')
#
#     university_info = university_soup.find('div', {'id': 'root'}) \
#         .find('div', {'class': 'container'}) \
#         .find('div', {'class': 'container'}) \
#         .find('div', {'class': 'container'}) \
#         .find('div', {'class': 'container'}) \
#         .find('div') \
#         .find('div', {'class': 'clearfix'}) \
#         .find('div', {'class': 'main'}) \
#         .find('div', {'class': 'layoutWarp clearfix'}) \
#         .find('div', {'class': 'relative-for-liuyan'}) \
#         .find('div', {'class': 'relative_box'}) \
#         .find('div', {'class': 'school clearfix'}) \
#         .find('div', {'class': 'schoolName clearfix school_view_top'}) \
#         .find('div', {'class': 'line1'}) \
#         .find_all('span', {'class': 'line1-schoolName'})
#
#     print(str(university_info))