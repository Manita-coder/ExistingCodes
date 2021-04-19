@2_All_Bild_Levels_seq_0_10_20_m20
@All
Feature: SA360

  Scenario: update cache
    Given I update cache

  Scenario Outline: Post API requests with  sickscore <sickscore> and geocodes <geocode>
    When I send an API request with geocode = "<geocode>", sickscore = <sickscore> for SA360

    Examples: 
      | geocode                               | sickscore |
      #| us-me-portland-auburn                 |        26 |
      | us-ny-new-york                        |        27 |
      | us-ny-binghamton                      |        28 |
      | us-ga-macon                           |        29 |
      | us-pa-philadelphia                    |        30 |
      | us-mi-detroit                         |        31 |
      | us-ma-boston-nh-manchester            |        32 |
      | us-ga-savannah                        |        33 |
      | us-pa-pittsburgh                      |        34 |
      | us-in-ft-wayne                        |        35 |
      | us-oh-cleveland-akron                 |        36 |
      | us-dc-washington-md-hagerstown        |        37 |
      | us-md-baltimore                       |        38 |
      | us-mi-flint-saginaw-bay-city          |        39 |
      | us-ny-buffalo                         |        40 |
      | us-oh-cincinnati                      |        41 |
      | us-pa-erie                            |        42 |
      | us-nc-charlotte                       |        43 |
      | us-nc-greensboro-winston-salem        |        44 |
      | us-sc-charleston                      |        45 |
      | us-ga-augusta                         |        46 |
      | us-ri-providence-ma-new-bedford       |        47 |
      | us-ga-columbus                        |        48 |
      | us-vt-burlington-ny-plattsburgh       |        49 |
      | us-ga-atlanta                         |        50 |
      | us-ga-albany                          |        51 |
      | us-ny-utica                           |        52 |
      | us-in-indianapolis                    |        53 |
      | us-fl-miami-ft-lauderdale             |        54 |
      | us-ky-louisville                      |        55 |
      | us-fl-tallahassee-ga-thomasville      |        56 |
      | us-tn-va-tri-cities                   |        57 |
      | us-ny-albany-schenectady-troy         |        58 |
      | us-ct-hartford-new-haven              |        59 |
      | us-fl-orlando-daytona-beach           |        60 |
      | us-oh-columbus                        |        61 |
      | us-oh-youngstown                      |        62 |
      | us-me-bangor                          |        63 |
      | us-ny-rochester                       |        64 |
      | us-fl-tampa-st-petersburg             |        65 |
      | us-mi-traverse-city-cadillac          |        66 |
      | us-ky-lexington                       |        67 |
      | us-oh-dayton                          |        68 |
      | us-ma-springfield-holyoke             |        69 |
      | us-va-norfolk-portsmouth-newport-news |        70 |
      | us-nc-greenville-new-bern-washington  |        71 |
      | us-sc-columbia                        |        72 |
      | us-oh-toledo                          |        73 |
      | us-fl-west-palm-beach-ft-pierce       |        74 |
      | us-ny-watertown                       |        75 |
      | us-nc-wilmington                      |        76 |
      | us-mi-lansing                         |        77 |
      | us-me-presque-isle                    |        78 |
      | us-me-marquette                       |        79 |
      | us-wv-wheeling-oh-steubenville        |        80 |
      | us-ny-syracuse                        |        81 |
      | us-va-richmond-petersburg             |        82 |
      | us-tn-knoxville                       |        83 |
      | us-oh-lima                            |        84 |
      | us-wv-bluefield-beckley-oak-hill      |        85 |
      | us-nc-raleigh-durham                  |        86 |
      | us-fl-jacksonville                    |        87 |
      | us-mi-grand-rapids-kalamazoo          |        88 |
      | us-wv-charleston-huntington           |        89 |
      | us-ny-elmira                          |        90 |
      | us-pa-harrisburg-lancaster-york       |        91 |
      | us-sc-greenville-spartanburg          |        92 |
      | us-va-harrisonburg                    |        93 |
      | us-sc-florence-myrtle-beach           |        94 |
      | us-fl-ft-myers-naples                 |        95 |
      | us-va-roanoke-lynchburg               |        96 |
      | us-pa-johnstown-altoona               |        97 |
      | us-tn-chattanooga                     |        98 |
      | us-md-salisbury                       |        99 |
      | us-pa-wilkes-barre-scranton           |       100 |
      | us-in-terre-haute                     |         1 |
      | us-in-lafayette                       |         2 |
      | us-mi-alpena                          |         3 |
      | us-va-charlottesville                 |         4 |
      | us-in-south-bend-elkhart              |         5 |
      | us-fl-gainesville                     |         6 |
      | us-oh-zanesville                      |         7 |
      | us-wv-parkersburg                     |         8 |
      | us-wv-clarksburg-weston               |         9 |
      | us-tx-corpus-christi                  |        10 |
      | us-il-chicago                         |        11 |
      | us-mo-joplin-ks-pittsburg             |        12 |
      | us-mo-columbia-jefferson-city         |        13 |
      | us-ks-topeka                          |        14 |
      | us-al-dothan                          |        15 |
      | us-mo-st-louis                        |        16 |
      | us-il-rockford                        |        17 |
      | us-mn-rochester-austin-ia-mason-city  |        18 |
      | us-la-shreveport                      |        19 |
      | us-mn-minneapolis-st-paul             |        20 |
      | us-mo-kansas-city                     |        21 |
      | us-wi-milwaukee                       |        22 |
      | us-tx-houston                         |        23 |
      | us-mo-springfield                     |        24 |
      | us-la-new-orleans                     |        25 |

  Scenario: Verify Bids after force upload
    Then I force Upload file
    Then I Download latest records from SA360 after 120 seconds and close browser

  Scenario Outline: Verify sickscore <sickscore> and geocodes <geocode> on DV360
    And Bid for - "<geocode>" should be "<Expected Bid>"

    Examples: 
      | geocode                               | sickscore | Expected Bid |
      #| us-me-portland-auburn                 |        26 | 0%           |
      | us-ny-new-york                        |        27 | 0%           |
      | us-ny-binghamton                      |        28 | 0%           |
      | us-ga-macon                           |        29 | 0%           |
      | us-pa-philadelphia                    |        30 | 0%           |
      | us-mi-detroit                         |        31 | 0%           |
      | us-ma-boston-nh-manchester            |        32 | 0%           |
      | us-ga-savannah                        |        33 | 0%           |
      | us-pa-pittsburgh                      |        34 | 0%           |
      | us-in-ft-wayne                        |        35 | 0%           |
      | us-oh-cleveland-akron                 |        36 | 0%           |
      | us-dc-washington-md-hagerstown        |        37 | 0%           |
      | us-md-baltimore                       |        38 | 0%           |
      | us-mi-flint-saginaw-bay-city          |        39 | 0%           |
      | us-ny-buffalo                         |        40 | 0%           |
      | us-oh-cincinnati                      |        41 | 0%           |
      | us-pa-erie                            |        42 | 0%           |
      | us-nc-charlotte                       |        43 | 0%           |
      | us-nc-greensboro-winston-salem        |        44 | 0%           |
      | us-sc-charleston                      |        45 | 0%           |
      | us-ga-augusta                         |        46 | 0%           |
      | us-ri-providence-ma-new-bedford       |        47 | 0%           |
      | us-ga-columbus                        |        48 | 0%           |
      | us-vt-burlington-ny-plattsburgh       |        49 | 0%           |
      | us-ga-atlanta                         |        50 | 0%           |
      | us-ga-albany                          |        51 | 10%          |
      | us-ny-utica                           |        52 | 10%          |
      | us-in-indianapolis                    |        53 | 10%          |
      | us-fl-miami-ft-lauderdale             |        54 | 10%          |
      | us-ky-louisville                      |        55 | 10%          |
      | us-fl-tallahassee-ga-thomasville      |        56 | 10%          |
      | us-tn-va-tri-cities                   |        57 | 10%          |
      | us-ny-albany-schenectady-troy         |        58 | 10%          |
      | us-ct-hartford-new-haven              |        59 | 10%          |
      | us-fl-orlando-daytona-beach           |        60 | 10%          |
      | us-oh-columbus                        |        61 | 10%          |
      | us-oh-youngstown                      |        62 | 10%          |
      | us-me-bangor                          |        63 | 10%          |
      | us-ny-rochester                       |        64 | 10%          |
      | us-fl-tampa-st-petersburg             |        65 | 10%          |
      | us-mi-traverse-city-cadillac          |        66 | 10%          |
      | us-ky-lexington                       |        67 | 10%          |
      | us-oh-dayton                          |        68 | 10%          |
      | us-ma-springfield-holyoke             |        69 | 10%          |
      | us-va-norfolk-portsmouth-newport-news |        70 | 10%          |
      | us-nc-greenville-new-bern-washington  |        71 | 10%          |
      | us-sc-columbia                        |        72 | 10%          |
      | us-oh-toledo                          |        73 | 10%          |
      | us-fl-west-palm-beach-ft-pierce       |        74 | 10%          |
      | us-ny-watertown                       |        75 | 10%          |
      | us-nc-wilmington                      |        76 | 20%          |
      | us-mi-lansing                         |        77 | 20%          |
      | us-me-presque-isle                    |        78 | 20%          |
      | us-me-marquette                       |        79 | 20%          |
      | us-wv-wheeling-oh-steubenville        |        80 | 20%          |
      | us-ny-syracuse                        |        81 | 20%          |
      | us-va-richmond-petersburg             |        82 | 20%          |
      | us-tn-knoxville                       |        83 | 20%          |
      | us-oh-lima                            |        84 | 20%          |
      | us-wv-bluefield-beckley-oak-hill      |        85 | 20%          |
      | us-nc-raleigh-durham                  |        86 | 20%          |
      | us-fl-jacksonville                    |        87 | 20%          |
      | us-mi-grand-rapids-kalamazoo          |        88 | 20%          |
      | us-wv-charleston-huntington           |        89 | 20%          |
      | us-ny-elmira                          |        90 | 20%          |
      | us-pa-harrisburg-lancaster-york       |        91 | 20%          |
      | us-sc-greenville-spartanburg          |        92 | 20%          |
      | us-va-harrisonburg                    |        93 | 20%          |
      | us-sc-florence-myrtle-beach           |        94 | 20%          |
      | us-fl-ft-myers-naples                 |        95 | 20%          |
      | us-va-roanoke-lynchburg               |        96 | 20%          |
      | us-pa-johnstown-altoona               |        97 | 20%          |
      | us-tn-chattanooga                     |        98 | 20%          |
      | us-md-salisbury                       |        99 | 20%          |
      | us-pa-wilkes-barre-scranton           |       100 | 20%          |
      | us-in-terre-haute                     |         1 | -20%         |
      | us-in-lafayette                       |         2 | -20%         |
      | us-mi-alpena                          |         3 | -20%         |
      | us-va-charlottesville                 |         4 | -20%         |
      | us-in-south-bend-elkhart              |         5 | -20%         |
      | us-fl-gainesville                     |         6 | -20%         |
      | us-oh-zanesville                      |         7 | -20%         |
      | us-wv-parkersburg                     |         8 | -20%         |
      | us-wv-clarksburg-weston               |         9 | -20%         |
      | us-tx-corpus-christi                  |        10 | -20%         |
      | us-il-chicago                         |        11 | -20%         |
      | us-mo-joplin-ks-pittsburg             |        12 | -20%         |
      | us-mo-columbia-jefferson-city         |        13 | -20%         |
      | us-ks-topeka                          |        14 | -20%         |
      | us-al-dothan                          |        15 | -20%         |
      | us-mo-st-louis                        |        16 | -20%         |
      | us-il-rockford                        |        17 | -20%         |
      | us-mn-rochester-austin-ia-mason-city  |        18 | -20%         |
      | us-la-shreveport                      |        19 | -20%         |
      | us-mn-minneapolis-st-paul             |        20 | -20%         |
      | us-mo-kansas-city                     |        21 | -20%         |
      | us-wi-milwaukee                       |        22 | -20%         |
      | us-tx-houston                         |        23 | -20%         |
      | us-mo-springfield                     |        24 | -20%         |
      | us-la-new-orleans                     |        25 | -20%         |
