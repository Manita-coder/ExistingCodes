@1_All_Bild_Levels_seq_m20_0_10_20
@All
Feature: SA360

#  Scenario: update cache
#    Given I update cache
#
#  Scenario Outline: Post API requests with  sickscore <sickscore> and geocodes <geocode>
#    When I send an API request with geocode = "<geocode>", sickscore = <sickscore> for SA360
#
#    Examples: 
#      | geocode                               | sickscore |
#      | us-me-portland-auburn                 |         1 |
#      | us-ny-new-york                        |         2 |
#      | us-ny-binghamton                      |         3 |
#      | us-ga-macon                           |         4 |
#      | us-pa-philadelphia                    |         5 |
#      | us-mi-detroit                         |         6 |
#      | us-ma-boston-nh-manchester            |         7 |
#      | us-ga-savannah                        |         8 |
#      | us-pa-pittsburgh                      |         9 |
#      | us-in-ft-wayne                        |        10 |
#      | us-oh-cleveland-akron                 |        11 |
#      | us-dc-washington-md-hagerstown        |        12 |
#      | us-md-baltimore                       |        13 |
#      | us-mi-flint-saginaw-bay-city          |        14 |
#      | us-ny-buffalo                         |        15 |
#      | us-oh-cincinnati                      |        16 |
#      | us-pa-erie                            |        17 |
#      | us-nc-charlotte                       |        18 |
#      | us-nc-greensboro-winston-salem        |        19 |
#      | us-sc-charleston                      |        20 |
#      | us-ga-augusta                         |        21 |
#      | us-ri-providence-ma-new-bedford       |        22 |
#      | us-ga-columbus                        |        23 |
#      | us-vt-burlington-ny-plattsburgh       |        24 |
#      | us-ga-atlanta                         |        25 |
#      | us-ga-albany                          |        26 |
#      | us-ny-utica                           |        27 |
#      | us-in-indianapolis                    |        28 |
#      | us-fl-miami-ft-lauderdale             |        29 |
#      | us-ky-louisville                      |        30 |
#      | us-fl-tallahassee-ga-thomasville      |        31 |
#      | us-tn-va-tri-cities                   |        32 |
#      | us-ny-albany-schenectady-troy         |        33 |
#      | us-ct-hartford-new-haven              |        34 |
#      | us-fl-orlando-daytona-beach           |        35 |
#      | us-oh-columbus                        |        36 |
#      | us-oh-youngstown                      |        37 |
#      | us-me-bangor                          |        38 |
#      | us-ny-rochester                       |        39 |
#      | us-fl-tampa-st-petersburg             |        40 |
#      | us-mi-traverse-city-cadillac          |        41 |
#      | us-ky-lexington                       |        42 |
#      | us-oh-dayton                          |        43 |
#      | us-ma-springfield-holyoke             |        44 |
#      | us-va-norfolk-portsmouth-newport-news |        45 |
#      | us-nc-greenville-new-bern-washington  |        46 |
#      | us-sc-columbia                        |        47 |
#      | us-oh-toledo                          |        48 |
#      | us-fl-west-palm-beach-ft-pierce       |        49 |
#      | us-ny-watertown                       |        50 |
#      | us-nc-wilmington                      |        51 |
#      | us-mi-lansing                         |        52 |
#      | us-me-presque-isle                    |        53 |
#      | us-me-marquette                       |        54 |
#      | us-wv-wheeling-oh-steubenville        |        55 |
#      | us-ny-syracuse                        |        56 |
#      | us-va-richmond-petersburg             |        57 |
#      | us-tn-knoxville                       |        58 |
#      | us-oh-lima                            |        59 |
#      | us-wv-bluefield-beckley-oak-hill      |        60 |
#      | us-nc-raleigh-durham                  |        61 |
#      | us-fl-jacksonville                    |        62 |
#      | us-mi-grand-rapids-kalamazoo          |        63 |
#      | us-wv-charleston-huntington           |        64 |
#      | us-ny-elmira                          |        65 |
#      | us-pa-harrisburg-lancaster-york       |        66 |
#      | us-sc-greenville-spartanburg          |        67 |
#      | us-va-harrisonburg                    |        68 |
#      | us-sc-florence-myrtle-beach           |        69 |
#      | us-fl-ft-myers-naples                 |        70 |
#      | us-va-roanoke-lynchburg               |        71 |
#      | us-pa-johnstown-altoona               |        72 |
#      | us-tn-chattanooga                     |        73 |
#      | us-md-salisbury                       |        74 |
#      | us-pa-wilkes-barre-scranton           |        75 |
#      | us-in-terre-haute                     |        76 |
#      | us-in-lafayette                       |        77 |
#      | us-mi-alpena                          |        78 |
#      | us-va-charlottesville                 |        79 |
#      | us-in-south-bend-elkhart              |        80 |
#      | us-fl-gainesville                     |        81 |
#      | us-oh-zanesville                      |        82 |
#      | us-wv-parkersburg                     |        83 |
#      | us-wv-clarksburg-weston               |        84 |
#      | us-tx-corpus-christi                  |        85 |
#      | us-il-chicago                         |        86 |
#      | us-mo-joplin-ks-pittsburg             |        87 |
#      | us-mo-columbia-jefferson-city         |        88 |
#      | us-ks-topeka                          |        89 |
#      | us-al-dothan                          |        90 |
#      | us-mo-st-louis                        |        91 |
#      | us-il-rockford                        |        92 |
#      | us-mn-rochester-austin-ia-mason-city  |        93 |
#      | us-la-shreveport                      |        94 |
#      | us-mn-minneapolis-st-paul             |        95 |
#      | us-mo-kansas-city                     |        96 |
#      | us-wi-milwaukee                       |        97 |
#      | us-tx-houston                         |        98 |
#      | us-mo-springfield                     |        99 |
#      | us-la-new-orleans                     |       100 |

  Scenario: Verify Bids after force upload
 #   Then I force Upload file
    Then I Download latest records from SA360 after 1 seconds and close browser

  Scenario Outline: Verify sickscore <sickscore> and geocodes <geocode> on DV360
    And Bid for - "<geocode>" should be "<Expected Bid>"

    Examples: 
      | geocode                               | sickscore | Expected Bid |
      | us-me-portland-auburn                 |         1 | -20%         |
      | us-ny-new-york                        |         2 | -20%         |
      | us-ny-binghamton                      |         3 | -20%         |
      | us-ga-macon                           |         4 | -20%         |
      | us-pa-philadelphia                    |         5 | -20%         |
      | us-mi-detroit                         |         6 | -20%         |
      | us-ma-boston-nh-manchester            |         7 | -20%         |
      | us-ga-savannah                        |         8 | -20%         |
      | us-pa-pittsburgh                      |         9 | -20%         |
      | us-in-ft-wayne                        |        10 | -20%         |
      | us-oh-cleveland-akron                 |        11 | -20%         |
      | us-dc-washington-md-hagerstown        |        12 | -20%         |
      | us-md-baltimore                       |        13 | -20%         |
      | us-mi-flint-saginaw-bay-city          |        14 | -20%         |
      | us-ny-buffalo                         |        15 | -20%         |
      | us-oh-cincinnati                      |        16 | -20%         |
      | us-pa-erie                            |        17 | -20%         |
      | us-nc-charlotte                       |        18 | -20%         |
      | us-nc-greensboro-winston-salem        |        19 | -20%         |
      | us-sc-charleston                      |        20 | -20%         |
      | us-ga-augusta                         |        21 | -20%         |
      | us-ri-providence-ma-new-bedford       |        22 | -20%         |
      | us-ga-columbus                        |        23 | -20%         |
      | us-vt-burlington-ny-plattsburgh       |        24 | -20%         |
      | us-ga-atlanta                         |        25 | -20%         |
      | us-ga-albany                          |        26 | 0%           |
      | us-ny-utica                           |        27 | 0%           |
      | us-in-indianapolis                    |        28 | 0%           |
      | us-fl-miami-ft-lauderdale             |        29 | 0%           |
      | us-ky-louisville                      |        30 | 0%           |
      | us-fl-tallahassee-ga-thomasville      |        31 | 0%           |
      | us-tn-va-tri-cities                   |        32 | 0%           |
      | us-ny-albany-schenectady-troy         |        33 | 0%           |
      | us-ct-hartford-new-haven              |        34 | 0%           |
      | us-fl-orlando-daytona-beach           |        35 | 0%           |
      | us-oh-columbus                        |        36 | 0%           |
      | us-oh-youngstown                      |        37 | 0%           |
      | us-me-bangor                          |        38 | 0%           |
      | us-ny-rochester                       |        39 | 0%           |
      | us-fl-tampa-st-petersburg             |        40 | 0%           |
      | us-mi-traverse-city-cadillac          |        41 | 0%           |
      | us-ky-lexington                       |        42 | 0%           |
      | us-oh-dayton                          |        43 | 0%           |
      | us-ma-springfield-holyoke             |        44 | 0%           |
      | us-va-norfolk-portsmouth-newport-news |        45 | 0%           |
      | us-nc-greenville-new-bern-washington  |        46 | 0%           |
      | us-sc-columbia                        |        47 | 0%           |
      | us-oh-toledo                          |        48 | 0%           |
      | us-fl-west-palm-beach-ft-pierce       |        49 | 0%           |
      | us-ny-watertown                       |        50 | 0%           |
      | us-nc-wilmington                      |        51 | 10%          |
      | us-mi-lansing                         |        52 | 10%          |
      | us-me-presque-isle                    |        53 | 10%          |
      | us-me-marquette                       |        54 | 10%          |
      | us-wv-wheeling-oh-steubenville        |        55 | 10%          |
      | us-ny-syracuse                        |        56 | 10%          |
      | us-va-richmond-petersburg             |        57 | 10%          |
      | us-tn-knoxville                       |        58 | 10%          |
      | us-oh-lima                            |        59 | 10%          |
      | us-wv-bluefield-beckley-oak-hill      |        60 | 10%          |
      | us-nc-raleigh-durham                  |        61 | 10%          |
      | us-fl-jacksonville                    |        62 | 10%          |
      | us-mi-grand-rapids-kalamazoo          |        63 | 10%          |
      | us-wv-charleston-huntington           |        64 | 10%          |
      | us-ny-elmira                          |        65 | 10%          |
      | us-pa-harrisburg-lancaster-york       |        66 | 10%          |
      | us-sc-greenville-spartanburg          |        67 | 10%          |
      | us-va-harrisonburg                    |        68 | 10%          |
      | us-sc-florence-myrtle-beach           |        69 | 10%          |
      | us-fl-ft-myers-naples                 |        70 | 10%          |
      | us-va-roanoke-lynchburg               |        71 | 10%          |
      | us-pa-johnstown-altoona               |        72 | 10%          |
      | us-tn-chattanooga                     |        73 | 10%          |
      | us-md-salisbury                       |        74 | 10%          |
      | us-pa-wilkes-barre-scranton           |        75 | 10%          |
      | us-in-terre-haute                     |        76 | 20%          |
      | us-in-lafayette                       |        77 | 20%          |
      | us-mi-alpena                          |        78 | 20%          |
      | us-va-charlottesville                 |        79 | 20%          |
      | us-in-south-bend-elkhart              |        80 | 20%          |
      | us-fl-gainesville                     |        81 | 20%          |
      | us-oh-zanesville                      |        82 | 20%          |
      | us-wv-parkersburg                     |        83 | 20%          |
      | us-wv-clarksburg-weston               |        84 | 20%          |
      | us-tx-corpus-christi                  |        85 | 20%          |
      | us-il-chicago                         |        86 | 20%          |
      | us-mo-joplin-ks-pittsburg             |        87 | 20%          |
      | us-mo-columbia-jefferson-city         |        88 | 20%          |
      | us-ks-topeka                          |        89 | 20%          |
      | us-al-dothan                          |        90 | 20%          |
      | us-mo-st-louis                        |        91 | 20%          |
      | us-il-rockford                        |        92 | 20%          |
      | us-mn-rochester-austin-ia-mason-city  |        93 | 20%          |
      | us-la-shreveport                      |        94 | 20%          |
      | us-mn-minneapolis-st-paul             |        95 | 20%          |
      | us-mo-kansas-city                     |        96 | 20%          |
      | us-wi-milwaukee                       |        97 | 20%          |
      | us-tx-houston                         |        98 | 20%          |
      | us-mo-springfield                     |        99 | 20%          |
      | us-la-new-orleans                     |       100 | 20%          |
