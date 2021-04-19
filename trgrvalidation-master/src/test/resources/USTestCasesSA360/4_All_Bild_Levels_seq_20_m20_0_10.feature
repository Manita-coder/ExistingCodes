@4_All_Bild_Levels_seq_20_m20_0_10
@All
Feature: SA360

  Scenario: update cache
    Given I update cache

  Scenario Outline: Post API requests with  sickscore <sickscore> and geocodes <geocode>
    When I send an API request with geocode = "<geocode>", sickscore = <sickscore> for SA360

    Examples: 
      | geocode                               | sickscore |
      #| us-me-portland-auburn                 |        76 |
      | us-ny-new-york                        |        77 |
      | us-ny-binghamton                      |        78 |
      | us-ga-macon                           |        79 |
      | us-pa-philadelphia                    |        80 |
      | us-mi-detroit                         |        81 |
      | us-ma-boston-nh-manchester            |        82 |
      | us-ga-savannah                        |        83 |
      | us-pa-pittsburgh                      |        84 |
      | us-in-ft-wayne                        |        85 |
      | us-oh-cleveland-akron                 |        86 |
      | us-dc-washington-md-hagerstown        |        87 |
      | us-md-baltimore                       |        88 |
      | us-mi-flint-saginaw-bay-city          |        89 |
      | us-ny-buffalo                         |        90 |
      | us-oh-cincinnati                      |        91 |
      | us-pa-erie                            |        92 |
      | us-nc-charlotte                       |        93 |
      | us-nc-greensboro-winston-salem        |        94 |
      | us-sc-charleston                      |        95 |
      | us-ga-augusta                         |        96 |
      | us-ri-providence-ma-new-bedford       |        97 |
      | us-ga-columbus                        |        98 |
      | us-vt-burlington-ny-plattsburgh       |        99 |
      | us-ga-atlanta                         |       100 |
      | us-ga-albany                          |         1 |
      | us-ny-utica                           |         2 |
      | us-in-indianapolis                    |         3 |
      | us-fl-miami-ft-lauderdale             |         4 |
      | us-ky-louisville                      |         5 |
      | us-fl-tallahassee-ga-thomasville      |         6 |
      | us-tn-va-tri-cities                   |         7 |
      | us-ny-albany-schenectady-troy         |         8 |
      | us-ct-hartford-new-haven              |         9 |
      | us-fl-orlando-daytona-beach           |        10 |
      | us-oh-columbus                        |        11 |
      | us-oh-youngstown                      |        12 |
      | us-me-bangor                          |        13 |
      | us-ny-rochester                       |        14 |
      | us-fl-tampa-st-petersburg             |        15 |
      | us-mi-traverse-city-cadillac          |        16 |
      | us-ky-lexington                       |        17 |
      | us-oh-dayton                          |        18 |
      | us-ma-springfield-holyoke             |        19 |
      | us-va-norfolk-portsmouth-newport-news |        20 |
      | us-nc-greenville-new-bern-washington  |        21 |
      | us-sc-columbia                        |        22 |
      | us-oh-toledo                          |        23 |
      | us-fl-west-palm-beach-ft-pierce       |        24 |
      | us-ny-watertown                       |        25 |
      | us-nc-wilmington                      |        26 |
      | us-mi-lansing                         |        27 |
      | us-me-presque-isle                    |        28 |
      | us-me-marquette                       |        29 |
      | us-wv-wheeling-oh-steubenville        |        30 |
      | us-ny-syracuse                        |        31 |
      | us-va-richmond-petersburg             |        32 |
      | us-tn-knoxville                       |        33 |
      | us-oh-lima                            |        34 |
      | us-wv-bluefield-beckley-oak-hill      |        35 |
      | us-nc-raleigh-durham                  |        36 |
      | us-fl-jacksonville                    |        37 |
      | us-mi-grand-rapids-kalamazoo          |        38 |
      | us-wv-charleston-huntington           |        39 |
      | us-ny-elmira                          |        40 |
      | us-pa-harrisburg-lancaster-york       |        41 |
      | us-sc-greenville-spartanburg          |        42 |
      | us-va-harrisonburg                    |        43 |
      | us-sc-florence-myrtle-beach           |        44 |
      | us-fl-ft-myers-naples                 |        45 |
      | us-va-roanoke-lynchburg               |        46 |
      | us-pa-johnstown-altoona               |        47 |
      | us-tn-chattanooga                     |        48 |
      | us-md-salisbury                       |        49 |
      | us-pa-wilkes-barre-scranton           |        50 |
      | us-in-terre-haute                     |        51 |
      | us-in-lafayette                       |        52 |
      | us-mi-alpena                          |        53 |
      | us-va-charlottesville                 |        54 |
      | us-in-south-bend-elkhart              |        55 |
      | us-fl-gainesville                     |        56 |
      | us-oh-zanesville                      |        57 |
      | us-wv-parkersburg                     |        58 |
      | us-wv-clarksburg-weston               |        59 |
      | us-tx-corpus-christi                  |        60 |
      | us-il-chicago                         |        61 |
      | us-mo-joplin-ks-pittsburg             |        62 |
      | us-mo-columbia-jefferson-city         |        63 |
      | us-ks-topeka                          |        64 |
      | us-al-dothan                          |        65 |
      | us-mo-st-louis                        |        66 |
      | us-il-rockford                        |        67 |
      | us-mn-rochester-austin-ia-mason-city  |        68 |
      | us-la-shreveport                      |        69 |
      | us-mn-minneapolis-st-paul             |        70 |
      | us-mo-kansas-city                     |        71 |
      | us-wi-milwaukee                       |        72 |
      | us-tx-houston                         |        73 |
      | us-mo-springfield                     |        74 |
      | us-la-new-orleans                     |        75 |

  Scenario: Verify Bids after force upload
    Then I force Upload file
    Then I Download latest records from SA360 after 120 seconds and close browser

  Scenario Outline: Verify sickscore <sickscore> and geocodes <geocode> on DV360
    And Bid for - "<geocode>" should be "<Expected Bid>"

    Examples: 
      | geocode                               | sickscore | Expected Bid |
      #| us-me-portland-auburn                 |        76 | 20%          |
      | us-ny-new-york                        |        77 | 20%          |
      | us-ny-binghamton                      |        78 | 20%          |
      | us-ga-macon                           |        79 | 20%          |
      | us-pa-philadelphia                    |        80 | 20%          |
      | us-mi-detroit                         |        81 | 20%          |
      | us-ma-boston-nh-manchester            |        82 | 20%          |
      | us-ga-savannah                        |        83 | 20%          |
      | us-pa-pittsburgh                      |        84 | 20%          |
      | us-in-ft-wayne                        |        85 | 20%          |
      | us-oh-cleveland-akron                 |        86 | 20%          |
      | us-dc-washington-md-hagerstown        |        87 | 20%          |
      | us-md-baltimore                       |        88 | 20%          |
      | us-mi-flint-saginaw-bay-city          |        89 | 20%          |
      | us-ny-buffalo                         |        90 | 20%          |
      | us-oh-cincinnati                      |        91 | 20%          |
      | us-pa-erie                            |        92 | 20%          |
      | us-nc-charlotte                       |        93 | 20%          |
      | us-nc-greensboro-winston-salem        |        94 | 20%          |
      | us-sc-charleston                      |        95 | 20%          |
      | us-ga-augusta                         |        96 | 20%          |
      | us-ri-providence-ma-new-bedford       |        97 | 20%          |
      | us-ga-columbus                        |        98 | 20%          |
      | us-vt-burlington-ny-plattsburgh       |        99 | 20%          |
      | us-ga-atlanta                         |       100 | 20%          |
      | us-ga-albany                          |         1 | -20%         |
      | us-ny-utica                           |         2 | -20%         |
      | us-in-indianapolis                    |         3 | -20%         |
      | us-fl-miami-ft-lauderdale             |         4 | -20%         |
      | us-ky-louisville                      |         5 | -20%         |
      | us-fl-tallahassee-ga-thomasville      |         6 | -20%         |
      | us-tn-va-tri-cities                   |         7 | -20%         |
      | us-ny-albany-schenectady-troy         |         8 | -20%         |
      | us-ct-hartford-new-haven              |         9 | -20%         |
      | us-fl-orlando-daytona-beach           |        10 | -20%         |
      | us-oh-columbus                        |        11 | -20%         |
      | us-oh-youngstown                      |        12 | -20%         |
      | us-me-bangor                          |        13 | -20%         |
      | us-ny-rochester                       |        14 | -20%         |
      | us-fl-tampa-st-petersburg             |        15 | -20%         |
      | us-mi-traverse-city-cadillac          |        16 | -20%         |
      | us-ky-lexington                       |        17 | -20%         |
      | us-oh-dayton                          |        18 | -20%         |
      | us-ma-springfield-holyoke             |        19 | -20%         |
      | us-va-norfolk-portsmouth-newport-news |        20 | -20%         |
      | us-nc-greenville-new-bern-washington  |        21 | -20%         |
      | us-sc-columbia                        |        22 | -20%         |
      | us-oh-toledo                          |        23 | -20%         |
      | us-fl-west-palm-beach-ft-pierce       |        24 | -20%         |
      | us-ny-watertown                       |        25 | -20%         |
      | us-nc-wilmington                      |        26 | 0%           |
      | us-mi-lansing                         |        27 | 0%           |
      | us-me-presque-isle                    |        28 | 0%           |
      | us-me-marquette                       |        29 | 0%           |
      | us-wv-wheeling-oh-steubenville        |        30 | 0%           |
      | us-ny-syracuse                        |        31 | 0%           |
      | us-va-richmond-petersburg             |        32 | 0%           |
      | us-tn-knoxville                       |        33 | 0%           |
      | us-oh-lima                            |        34 | 0%           |
      | us-wv-bluefield-beckley-oak-hill      |        35 | 0%           |
      | us-nc-raleigh-durham                  |        36 | 0%           |
      | us-fl-jacksonville                    |        37 | 0%           |
      | us-mi-grand-rapids-kalamazoo          |        38 | 0%           |
      | us-wv-charleston-huntington           |        39 | 0%           |
      | us-ny-elmira                          |        40 | 0%           |
      | us-pa-harrisburg-lancaster-york       |        41 | 0%           |
      | us-sc-greenville-spartanburg          |        42 | 0%           |
      | us-va-harrisonburg                    |        43 | 0%           |
      | us-sc-florence-myrtle-beach           |        44 | 0%           |
      | us-fl-ft-myers-naples                 |        45 | 0%           |
      | us-va-roanoke-lynchburg               |        46 | 0%           |
      | us-pa-johnstown-altoona               |        47 | 0%           |
      | us-tn-chattanooga                     |        48 | 0%           |
      | us-md-salisbury                       |        49 | 0%           |
      | us-pa-wilkes-barre-scranton           |        50 | 0%           |
      | us-in-terre-haute                     |        51 | 10%          |
      | us-in-lafayette                       |        52 | 10%          |
      | us-mi-alpena                          |        53 | 10%          |
      | us-va-charlottesville                 |        54 | 10%          |
      | us-in-south-bend-elkhart              |        55 | 10%          |
      | us-fl-gainesville                     |        56 | 10%          |
      | us-oh-zanesville                      |        57 | 10%          |
      | us-wv-parkersburg                     |        58 | 10%          |
      | us-wv-clarksburg-weston               |        59 | 10%          |
      | us-tx-corpus-christi                  |        60 | 10%          |
      | us-il-chicago                         |        61 | 10%          |
      | us-mo-joplin-ks-pittsburg             |        62 | 10%          |
      | us-mo-columbia-jefferson-city         |        63 | 10%          |
      | us-ks-topeka                          |        64 | 10%          |
      | us-al-dothan                          |        65 | 10%          |
      | us-mo-st-louis                        |        66 | 10%          |
      | us-il-rockford                        |        67 | 10%          |
      | us-mn-rochester-austin-ia-mason-city  |        68 | 10%          |
      | us-la-shreveport                      |        69 | 10%          |
      | us-mn-minneapolis-st-paul             |        70 | 10%          |
      | us-mo-kansas-city                     |        71 | 10%          |
      | us-wi-milwaukee                       |        72 | 10%          |
      | us-tx-houston                         |        73 | 10%          |
      | us-mo-springfield                     |        74 | 10%          |
      | us-la-new-orleans                     |        75 | 10%          |
