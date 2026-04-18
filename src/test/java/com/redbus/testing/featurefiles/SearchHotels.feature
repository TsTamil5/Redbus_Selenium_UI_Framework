Feature: Hotels Feature

Background:
Given Open the Browser
And Navigate to RedBus Application "https://www.redbus.in/"

Scenario: Navigate to the Hotels page and validate user can successfully reach the Hotels page
When Click on Hotels tab
Then Verify Hotels page is displayed

Scenario Outline: Click any hotel card in Flash Deals and validate Download App popup is displayed
When Click on Hotels tab
And Click hotel card from Flash Deals section by index "<Index>"
Then Verify Download App popup is displayed

Examples:
| Index |
| 2     |

Scenario: Search hotels with city, dates, rooms and adults using excel data
When Click on Hotels tab
And Enter city name from excel sheet "HotelsData" row 1
And Select check-in date from excel sheet "HotelsData" row 1
And Select check-out date from excel sheet "HotelsData" row 1
And Click on rooms and guests field
And Select rooms count from excel sheet "HotelsData" row 1
And Select adults count from excel sheet "HotelsData" row 1
And Click on Search button
Then Verify hotel results page is displayed
And Verify searched city results are displayed

Scenario: Search hotels with children added but child age not selected
When Click on Hotels tab
And Enter city name from excel sheet "HotelsData" row 2
And Select check-in date from excel sheet "HotelsData" row 2
And Select check-out date from excel sheet "HotelsData" row 2
And Click on rooms and guests field
And Select rooms count from excel sheet "HotelsData" row 2
And Select adults count from excel sheet "HotelsData" row 2
And Add children count from excel sheet "HotelsData" row 2
And Click on Search button
Then Verify child age selection validation message is displayed

Scenario: Search hotels with children and child age using excel data
When Click on Hotels tab
And Enter city name from excel sheet "HotelsData" row 3
And Select check-in date from excel sheet "HotelsData" row 3
And Select check-out date from excel sheet "HotelsData" row 3
And Click on rooms and guests field
And Select rooms count from excel sheet "HotelsData" row 3
And Select adults count from excel sheet "HotelsData" row 3
And Add children count from excel sheet "HotelsData" row 3
And Select child age from excel sheet "HotelsData" row 3
And Click on Search button
Then Verify hotel results page is displayed

Scenario Outline: Apply hotel filters and validate clear all button with filtered results
When Click on Hotels tab
And Enter city name from excel sheet "HotelsData" row 4
And Select check-in date from excel sheet "HotelsData" row 4
And Select check-out date from excel sheet "HotelsData" row 4
And Click on rooms and guests field
And Select rooms count from excel sheet "HotelsData" row 4
And Select adults count from excel sheet "HotelsData" row 4
And Click on Search button
And Apply hotel filter "<FilterType>" with value "<FilterValue>"
Then Verify Clear Filter button is displayed
And Verify hotel results page is displayed

Examples:
| FilterType      | FilterValue     |
| Customer Rating | Excellent       |
| Price    | ₹0 - ₹1,000 |

Scenario Outline: Verify property count mismatch bug after applying filters
When Click on Hotels tab
And Enter city name from excel sheet "HotelsData" row 5
And Select check-in date from excel sheet "HotelsData" row 5
And Select check-out date from excel sheet "HotelsData" row 5
And Click on rooms and guests field
And Select rooms count from excel sheet "HotelsData" row 5
And Select adults count from excel sheet "HotelsData" row 5
And Click on Search button
And Apply hotel filter "<FilterType>" with value "<FilterValue>"
Then Verify property count mismatch bug is displayed

Examples:
| FilterType      | FilterValue     |
| Customer Rating | Excellent       |
| Price           | ₹0 - ₹1,000     |
| Meal Preference | Free Breakfast  |
