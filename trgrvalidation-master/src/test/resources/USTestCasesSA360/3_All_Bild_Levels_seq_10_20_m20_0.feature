@3_All_Bild_Levels_seq_10_20_m20_0
@All
Feature: SA360

  Scenario: update cache
    Given I update cache

  Scenario Outline: Post API requests with  sickscore <sickscore> and geocodes <geocode>
    When I send an API request with geocode = "<geocode>", sickscore = <sickscore> for SA360

    Examples: 
      | geocode                               | sickscore |
      #| us-me-portland-auburn                 |        51 |
      | us-ny-new-york                        |        52 |
      | us-ny-binghamton                      |        53 |
      | us-ga-macon                           |        54 |
      | us-pa-philadelphia                    |        55 |
      | us-mi-detroit                         |        56 |
      | us-ma-boston-nh-manchester            |        57 |
      | us-ga-savannah                        |        58 |
      | us-pa-pittsburgh                      |        59 |
      | us-in-ft-wayne                        |        60 |
      | us-oh-cleveland-akron                 |        61 |
      | us-dc-washington-md-hagerstown        |        62 |
      | us-md-baltimore                       |        63 |
      | us-mi-flint-saginaw-bay-city          |        64 |
      | us-ny-buffalo                         |        65 |
      | us-oh-cincinnati                      |        66 |
      | us-pa-erie                            |        67 |
      | us-nc-charlotte                       |        68 |
      | us-nc-greensboro-winston-salem        |        69 |
      | us-sc-charleston                      |        70 |
      | us-ga-augusta                         |        71 |
      | us-ri-providence-ma-new-bedford       |        72 |
      | us-ga-columbus                        |        73 |
      | us-vt-burlington-ny-plattsburgh       |        74 |
      | us-ga-atlanta                         |        75 |
      | us-ga-albany                          |        76 |
      | us-ny-utica                           |        77 |
      | us-in-indianapolis                    |        78 |
      | us-fl-miami-ft-lauderdale             |        79 |
      | us-ky-louisville                      |        80 |
      | us-fl-tallahassee-ga-thomasville      |        81 |
      | us-tn-va-tri-cities                   |        82 |
      | us-ny-albany-schenectady-troy         |        83 |
      | us-ct-hartford-new-haven              |        84 |
      | us-fl-orlando-daytona-beach           |        85 |
      | us-oh-columbus                        |        86 |
      | us-oh-youngstown                      |        87 |
      | us-me-bangor                          |        88 |
      | us-ny-rochester                       |        89 |
      | us-fl-tampa-st-petersburg             |        90 |
      | us-mi-traverse-city-cadillac          |        91 |
      | us-ky-lexington                       |        92 |
      | us-oh-dayton                          |        93 |
      | us-ma-springfield-holyoke             |        94 |
      | us-va-norfolk-portsmouth-newport-news |        95 |
      | us-nc-greenville-new-bern-washington  |        96 |
      | us-sc-columbia                        |        97 |
      | us-oh-toledo                          |        98 |
      | us-fl-west-palm-beach-ft-pierce       |        99 |
      | us-ny-watertown                       |       100 |
      | us-nc-wilmington                      |         1 |
      | us-mi-lansing                         |         2 |
      | us-me-presque-isle                    |         3 |
      | us-me-marquette                       |         4 |
      | us-wv-wheeling-oh-steubenville        |         5 |
      | us-ny-syracuse                        |         6 |
      | us-va-richmond-petersburg             |         7 |
      | us-tn-knoxville                       |         8 |
      | us-oh-lima                            |         9 |
      | us-wv-bluefield-beckley-oak-hill      |        10 |
      | us-nc-raleigh-durham                  |        11 |
      | us-fl-jacksonville                    |        12 |
      | us-mi-grand-rapids-kalamazoo          |        13 |
      | us-wv-charleston-huntington           |        14 |
      | us-ny-elmira                          |        15 |
      | us-pa-harrisburg-lancaster-york       |        16 |
      | us-sc-greenville-spartanburg          |        17 |
      | us-va-harrisonburg                    |        18 |
      | us-sc-florence-myrtle-beach           |        19 |
      | us-fl-ft-myers-naples                 |        20 |
      | us-va-roanoke-lynchburg               |        21 |
      | us-pa-johnstown-altoona               |        22 |
      | us-tn-chattanooga                     |        23 |
      | us-md-salisbury                       |        24 |
      | us-pa-wilkes-barre-scranton           |        25 |
      | us-in-terre-haute                     |        26 |
      | us-in-lafayette                       |        27 |
      | us-mi-alpena                          |        28 |
      | us-va-charlottesville                 |        29 |
      | us-in-south-bend-elkhart              |        30 |
      | us-fl-gainesville                     |        31 |
      | us-oh-zanesville                      |        32 |
      | us-wv-parkersburg                     |        33 |
      | us-wv-clarksburg-weston               |        34 |
      | us-tx-corpus-christi                  |        35 |
      | us-il-chicago                         |        36 |
      | us-mo-joplin-ks-pittsburg             |        37 |
      | us-mo-columbia-jefferson-city         |        38 |
      | us-ks-topeka                          |        39 |
      | us-al-dothan                          |        40 |
      | us-mo-st-louis                        |        41 |
      | us-il-rockford                        |        42 |
      | us-mn-rochester-austin-ia-mason-city  |        43 |
      | us-la-shreveport                      |        44 |
      | us-mn-minneapolis-st-paul             |        45 |
      | us-mo-kansas-city                     |        46 |
      | us-wi-milwaukee                       |        47 |
      | us-tx-houston                         |        48 |
      | us-mo-springfield                     |        49 |
      | us-la-new-orleans                     |        50 |

  Scenario: Verify Bids after force upload
    Then I force Upload file
    Then I Download latest records from SA360 after 120 seconds and close browser

  Scenario Outline: Verify sickscore <sickscore> and geocodes <geocode> on DV360
    And Bid for - "<geocode>" should be "<Expected Bid>"

    Examples: 
      | geocode                               | sickscore | Expected Bid |
      #| us-me-portland-auburn                 |        51 | 10%          |
      | us-ny-new-york                        |        52 | 10%          |
      | us-ny-binghamton                      |        53 | 10%          |
      | us-ga-macon                           |        54 | 10%          |
      | us-pa-philadelphia                    |        55 | 10%          |
      | us-mi-detroit                         |        56 | 10%          |
      | us-ma-boston-nh-manchester            |        57 | 10%          |
      | us-ga-savannah                        |        58 | 10%          |
      | us-pa-pittsburgh                      |        59 | 10%          |
      | us-in-ft-wayne                        |        60 | 10%          |
      | us-oh-cleveland-akron                 |        61 | 10%          |
      | us-dc-washington-md-hagerstown        |        62 | 10%          |
      | us-md-baltimore                       |        63 | 10%          |
      | us-mi-flint-saginaw-bay-city          |        64 | 10%          |
      | us-ny-buffalo                         |        65 | 10%          |
      | us-oh-cincinnati                      |        66 | 10%          |
      | us-pa-erie                            |        67 | 10%          |
      | us-nc-charlotte                       |        68 | 10%          |
      | us-nc-greensboro-winston-salem        |        69 | 10%          |
      | us-sc-charleston                      |        70 | 10%          |
      | us-ga-augusta                         |        71 | 10%          |
      | us-ri-providence-ma-new-bedford       |        72 | 10%          |
      | us-ga-columbus                        |        73 | 10%          |
      | us-vt-burlington-ny-plattsburgh       |        74 | 10%          |
      | us-ga-atlanta                         |        75 | 10%          |
      | us-ga-albany                          |        76 | 20%          |
      | us-ny-utica                           |        77 | 20%          |
      | us-in-indianapolis                    |        78 | 20%          |
      | us-fl-miami-ft-lauderdale             |        79 | 20%          |
      | us-ky-louisville                      |        80 | 20%          |
      | us-fl-tallahassee-ga-thomasville      |        81 | 20%          |
      | us-tn-va-tri-cities                   |        82 | 20%          |
      | us-ny-albany-schenectady-troy         |        83 | 20%          |
      | us-ct-hartford-new-haven              |        84 | 20%          |
      | us-fl-orlando-daytona-beach           |        85 | 20%          |
      | us-oh-columbus                        |        86 | 20%          |
      | us-oh-youngstown                      |        87 | 20%          |
      | us-me-bangor                          |        88 | 20%          |
      | us-ny-rochester                       |        89 | 20%          |
      | us-fl-tampa-st-petersburg             |        90 | 20%          |
      | us-mi-traverse-city-cadillac          |        91 | 20%          |
      | us-ky-lexington                       |        92 | 20%          |
      | us-oh-dayton                          |        93 | 20%          |
      | us-ma-springfield-holyoke             |        94 | 20%          |
      | us-va-norfolk-portsmouth-newport-news |        95 | 20%          |
      | us-nc-greenville-new-bern-washington  |        96 | 20%          |
      | us-sc-columbia                        |        97 | 20%          |
      | us-oh-toledo                          |        98 | 20%          |
      | us-fl-west-palm-beach-ft-pierce       |        99 | 20%          |
      | us-ny-watertown                       |       100 | 20%          |
      | us-nc-wilmington                      |         1 | -20%         |
      | us-mi-lansing                         |         2 | -20%         |
      | us-me-presque-isle                    |         3 | -20%         |
      | us-me-marquette                       |         4 | -20%         |
      | us-wv-wheeling-oh-steubenville        |         5 | -20%         |
      | us-ny-syracuse                        |         6 | -20%         |
      | us-va-richmond-petersburg             |         7 | -20%         |
      | us-tn-knoxville                       |         8 | -20%         |
      | us-oh-lima                            |         9 | -20%         |
      | us-wv-bluefield-beckley-oak-hill      |        10 | -20%         |
      | us-nc-raleigh-durham                  |        11 | -20%         |
      | us-fl-jacksonville                    |        12 | -20%         |
      | us-mi-grand-rapids-kalamazoo          |        13 | -20%         |
      | us-wv-charleston-huntington           |        14 | -20%         |
      | us-ny-elmira                          |        15 | -20%         |
      | us-pa-harrisburg-lancaster-york       |        16 | -20%         |
      | us-sc-greenville-spartanburg          |        17 | -20%         |
      | us-va-harrisonburg                    |        18 | -20%         |
      | us-sc-florence-myrtle-beach           |        19 | -20%         |
      | us-fl-ft-myers-naples                 |        20 | -20%         |
      | us-va-roanoke-lynchburg               |        21 | -20%         |
      | us-pa-johnstown-altoona               |        22 | -20%         |
      | us-tn-chattanooga                     |        23 | -20%         |
      | us-md-salisbury                       |        24 | -20%         |
      | us-pa-wilkes-barre-scranton           |        25 | -20%         |
      | us-in-terre-haute                     |        26 | 0%           |
      | us-in-lafayette                       |        27 | 0%           |
      | us-mi-alpena                          |        28 | 0%           |
      | us-va-charlottesville                 |        29 | 0%           |
      | us-in-south-bend-elkhart              |        30 | 0%           |
      | us-fl-gainesville                     |        31 | 0%           |
      | us-oh-zanesville                      |        32 | 0%           |
      | us-wv-parkersburg                     |        33 | 0%           |
      | us-wv-clarksburg-weston               |        34 | 0%           |
      | us-tx-corpus-christi                  |        35 | 0%           |
      | us-il-chicago                         |        36 | 0%           |
      | us-mo-joplin-ks-pittsburg             |        37 | 0%           |
      | us-mo-columbia-jefferson-city         |        38 | 0%           |
      | us-ks-topeka                          |        39 | 0%           |
      | us-al-dothan                          |        40 | 0%           |
      | us-mo-st-louis                        |        41 | 0%           |
      | us-il-rockford                        |        42 | 0%           |
      | us-mn-rochester-austin-ia-mason-city  |        43 | 0%           |
      | us-la-shreveport                      |        44 | 0%           |
      | us-mn-minneapolis-st-paul             |        45 | 0%           |
      | us-mo-kansas-city                     |        46 | 0%           |
      | us-wi-milwaukee                       |        47 | 0%           |
      | us-tx-houston                         |        48 | 0%           |
      | us-mo-springfield                     |        49 | 0%           |
      | us-la-new-orleans                     |        50 | 0%           |
