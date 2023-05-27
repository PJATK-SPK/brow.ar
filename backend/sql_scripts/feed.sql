-- MANUFACTURERS
INSERT INTO core.manufacturers ("name") VALUES ('Sulimar Sp z o.o.');
INSERT INTO core.manufacturers ("name") VALUES ('Browar Głubczyce S.A.');
INSERT INTO core.manufacturers ("name") VALUES ('FUHRMANN');
INSERT INTO core.manufacturers ("name") VALUES ('Browar Jabłonowo');
INSERT INTO core.manufacturers ("name") VALUES ('Van Pur SA.');

-- BEERS
INSERT INTO core.beers ("name", description, image_url, manufacturer_id) 
VALUES(
    'Beczkowe Mocne 9% Wiśnia', 
    'Piwo mocne o smaku wiśniowym. Zawiera cukry i substancje słodzące. Składniki: woda, słód jęczmienny, jęczmień browarny, syrop glukozowy, cukier, sok wiśniowy odtworzony z zagęszczonego soku wiśniowego; kwas: kwas cytrynowy; koncentrat z marchwi, aromat wiśniowy, substancje słodzące: sukraloza, acesufam K; chmiel.', 
    'https://ocen-piwo.pl/upload/accb76bf24cb04e49087be4276c62b78.webp', 
    (SELECT id FROM core.manufacturers WHERE name = 'Sulimar Sp z o.o.'));

INSERT INTO core.beers ("name", description, image_url, manufacturer_id) 
VALUES(
    'Halne Mocne', 
    'Barwa złocista, wpadająca w bursztyn. Piana biała, minimalna. Redukuje się błyskawicznie z głośnym sykiem. Po kilku łykach odeszła w zapomnienie. Nasycenie dość spore, choć z każdym łykiem maleje. Zapach słabiutki bardzo. W tle małe co nieco słodu. Smak nawet dość przyjemny, bo spodziewałem się klasycznego mózgotrzepa. Nieco słodu i lekkiego kwasku. Pojawia się też odrobina owocowej słodyczy. Alkohol nie jest wyczuwalny. Goryczka z tych słabszych, ale daje znać o sobie. Piwko jak na swoją moc wydaje mi się nazbyt wodniste, choć w głowę idzie i owszem. Na letnie wycieczki do plecaka jak znalazł.', 
    'https://ocen-piwo.pl/upload/3fded0e3821a0b64ef42252edd847152.webp', 
    (SELECT id FROM core.manufacturers WHERE name = 'Van Pur SA.'));

INSERT INTO core.beers ("name", description, image_url, manufacturer_id) 
VALUES(
    'Piwny Bączek', 
    'Piwny Bączek to mocne piwo w małej butelce. Teraz możesz po nie sięgnąć zawsze wtedy, kiedy masz ochotę poczuć smak prawdziwie mocnego trunku.', 
    'https://ocen-piwo.pl/upload/fef8d6a8740ff8fbd6ef641f9ca30cf4.webp', 
    null);

INSERT INTO core.beers ("name", description, image_url, manufacturer_id) 
VALUES(
    'Jabłonowo Super Mocne', 
    'Bardzo mocne piwo o barwie ciemnobursztynowej. Piana biała, nietrwała, znika bardzo szybko. Zapach słodowy z wyraźnym akcentem chmielowym. Smak słodowy, umiarkowanie słodki. W smaku i zapachu wyczuwalny alkohol. Dostępne w butelkach PET o pojemności 0,9l.', 
    'https://ocen-piwo.pl/upload/jablonowo-super-mocne.webp', 
    (SELECT id FROM core.manufacturers WHERE name = 'Browar Jabłonowo'));

INSERT INTO core.beers ("name", description, image_url, manufacturer_id) 
VALUES(
    'Special Mocne', 
    'Piwo w stylu mocny lager uwarzone przez Browar Głubczyce. Ciemnobursztynowa barwa, intensywna goryczka obfita piana i chmielowy aromat to tajemnice niepowtarzalności tego piwa. Warzone ze szczególną starannością spełnia wymagania wszystkich, którzy cenią zdecydowany mocny smak. Wrażenia smakowe potęguje szlachetny kolor oraz masa pęcherzyków dwutlenku węgla unoszących się w górę. Szlachetna goryczka sprawia, że każdy kufel tego piwa to prawdziwa przyjemność. Dostępne w puszkach o pojemności 500 ml.', 
    'https://ocen-piwo.pl/upload/08a6df6592f89df3a2c66ea86d6d75ed.webp', 
    (SELECT id FROM core.manufacturers WHERE name = 'Browar Głubczyce S.A.'));

INSERT INTO core.beers ("name", description, image_url, manufacturer_id) 
VALUES(
    'Karlsquell Mocne', 
    'Piwo uwarzone przez Van Pur S.A. Dostępne w sieci niemieckich marketów Aldi. Składniki: woda, słód jęczmienny, jęczmień browarny, chmiel, ekstrakt chmielu. Piwo jasne, mocne, pasteryzowane.', 
    'https://ocen-piwo.pl/upload/c7ee66bcf3246cda7cca9cf501f41207.webp', 
    (SELECT id FROM core.manufacturers WHERE name = 'Van Pur SA.'));

INSERT INTO core.beers ("name", description, image_url, manufacturer_id) 
VALUES(
    'Szlacheckie Mocne', 
    'Piwo jasne, pasteryzowane z Browaru Fuhrmann w Połczynie-Zdroju. Oryginalna receptura, warzone tradycyjnie.', 
    'https://ocen-piwo.pl/upload/szlacheckie.webp', 
    (SELECT id FROM core.manufacturers WHERE name = 'FUHRMANN'));

INSERT INTO core.beers ("name", description, image_url, manufacturer_id) 
VALUES(
    'Boorg Mocne', 
    'Boorg piwo mocne, pasteryzowane. Piwo dostępne w sieci Netto. Cena/Jakość wypada bardzo dobrze. Jak na taką moc w smaku jest bardzo neutralne. Nie zalatuje fermentowanymi owocami itp.', 
    'https://ocen-piwo.pl/upload/3c3a57d4abaeb31dd37881c808b59252.webp', 
    (SELECT id FROM core.manufacturers WHERE name = 'Van Pur SA.'));

-- COMMENTS
INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Beczkowe Mocne 9% Wiśnia'), 
    'Piwo beczkowe Mocne Wiśnia to absolutna petarda dla fanów wiśniowego szaleństwa i niegrzecznych napojów. To polska perła, która wgniata cię w fotel swoim wyrazistym charakterem i mocą.
Wygląd tego piwa to prawdziwa uczta dla oczu - głęboki, rubinowy kolor, który krzyczy: \"Wypij mnie, jeśli masz jaja!\" Aromat bije po nosie intensywnymi nutami soczystych, słodkich wiśni. Już sam zapach sprawia, że trudno oprzeć się pokusie i sięgnąć po pierwszy łyk.
W smaku Mocne Wiśnia to prawdziwa eksplozja zmysłów. Słodkie, soczyste wiśnie walczą z mocą piwa, tworząc burzliwe połączenie, które kusi i oczarowuje. To piwo jest pełne, z charakterem, który kopie cię prosto w jaja, ale jednocześnie orzeźwia i dodaje ci energii do szaleństwa.');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Beczkowe Mocne 9% Wiśnia'), 
    'Kiedy kosztuję tej ambrozji, wszystkie moje kubki smakowe zaczynają wariować. Czuje przecudowny smak wiśni jak i również siarki i aluminium. Nie przeszkadza mi to, ponieważ po 3 browarach już latam po ścianach. Jest to jeden z lepszych trunków jakie moje podniebienie zasmakowało przez moją drogę zwaną życiem.
Pozdrawiam');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Beczkowe Mocne 9% Wiśnia'), 
    'Niezły SYF ale po czwartym nie zwracam już na to uwagi ...');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Beczkowe Mocne 9% Wiśnia'), 
    'Bardzo ciekawe piwo aczkolwiek w brew pozorom ( myślałem że będzie to smak lekarstwa zamieniającego się w gorzki antybiotyk) browar był całkiem dobry odrazu poczułem bardzo słodki smak (landrynkowy)i lekki gaz wszystko to połączone z dużym woltarzem aczkolwiek ten był słabo wyczuwalny pewnie przez te wszystkie słodziki jak za 3 zł z groszami to nie najgorzej wacham się między 6,5-7');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Halne Mocne'), 
    'Klasyk od Van Pura, kiedyś piłem często. Woda + lekka goryczka alkoholowa.');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Halne Mocne'), 
    'Doszła do mnie nowa partia halnego. I rzeczywiście jest 6,1% alk. Zamiast halne mocne 7%. Jest teraz napisane halne strong 6,1%. Szkoda że nie da się wrzucać tu zdjęć. To bym dodał. Trzeba zmienić opis tutaj. I załączyć aktualną wersję zdjęcia puszki.');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Halne Mocne'), 
    'pozdrawiam mareczka z autobusu');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Piwny Bączek'), 
    'TODO');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Piwny Bączek'), 
    'Nieeee... Nie polecam tego pić, jedzie spirytem, że łuhuhu');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Piwny Bączek'), 
    'Bardzo zasmaczniste mocne piwko dla tych co są koneserami i smakoszami takowych. Ci co chleją piwne oranżadki czy koncerniaki niech nie sięgają po nie bo mogą nie trafić ze sklepu z powrotem do swojego domu. Schłodzone lekko wchodzi. Nie czuć o dziwo alkoholu, który kryje się pod dobrą goryczką i chmielem. Doskonała popitka do czegoś jeszcze mocniejszego ...');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Piwny Bączek'), 
    'Piwo kwaśne, krótko warzone. Fermentacja zatrzymana spirytusem. Po odkapslowaniu unosi się aromat siarki.');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Piwny Bączek'), 
    'Zdziera pape z dachu');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Jabłonowo Super Mocne'), 
    'Członek będzie stał jak kamień');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Jabłonowo Super Mocne'), 
    'Jak na mocne piwo i za taką cenę nie jest złe, ale wybitne też nie. Takie 5/10');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Jabłonowo Super Mocne'), 
    'Browar, dla prawdziwych mężczyzn to już nie są przelewki. Polecam jak chcesz szybko imprezę skończyć.');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Jabłonowo Super Mocne'), 
    'Jak jesteś już solidnie nayebany, to jest to dobry finisher. Na koniec jeden plastik i jest fantastic');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Special Mocne'), 
    'Raz nabyłem w sklepie pod pięknym Rostowem(k. Koszalina), kupiłem je na biwak, bo w sklepie nie było innego. No i byłem ciekawy, co to za SpecJal, bo nigdzie takiego nie widziałem. Dramat, ale w sumie nie widzę różnicy między powszechnym Specjalem a tym Specialem. Tym bardziej, jeśli może być tańszy od popularniejszego bliźniaka.');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Special Mocne'), 
    'ogółem to nawet mi smakuje, wlasnie dopijam drugie i chłodziłem je 40 minut w zamrażarku i pije sobie teraz całkiem możliwe');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Special Mocne'), 
    'Nawet największemu wrogowi nie życzę takiego.... czegoś.');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Special Mocne'), 
    'Faktycznie.cieżko to pić.a głubczyce kiedys robiły takie dobre piwo.');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Karlsquell Mocne'), 
    'Mega dobre piwko polecam jak ktoś chcę dobre piwko o mocnym voltarzu wypić nowa puszka spoko');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Karlsquell Mocne'), 
    'Witajcie ludziska. Wersja poprzednia dostępna do lutego to okrutne kwaśno słodkie popłuczyny. Dla amatorów takich piwek chyba. Teraz wytwarzanie przejął VanPur. Smak o niebo lepszy. Minimalnie skoczył woltarz do 7.2. Ale ja mam z tym piwem problem. Wczoraj wypiłem całe dwa. Czyli było \"grubo\". Pół nocy męczyłem się bez snu z ogólnym słabym samopoczuciem. Więc może to tylko u mnie a może zaczynają produkować tuningi alkoholowe dla najtrwalszych. Dla mnie temat tego piwa zamknięty. Never more. Pozdrawiam drawiam');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Karlsquell Mocne'), 
    'Piwo zmieniło moc na 7,2% i ekstrakt na 12,1 oraz szatę graficzną. Smak też się poprawił. Nie ma już kwasu jest słodowość i nawet odrobina goryczki. Aromat po ogrzaniu robi się kwaśnawy ale nie wali warzywami czy masłem jak niektóre strong lagery. Jak na piwo mocne poniżej 3pln jest ok. Wiadomo, że picie w większej ilości może mieć przykre konsekwencje ale po jednym czułem się dobrze.');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Karlsquell Mocne'), 
    'Kwaśne w smaku ale po cenie i woltażu chyba idzie się domyśleć, że to jest do wychlania pod mostem, a nie do degustacji. Ja osobiście jako amator tanich siekier daję mu 6/10.');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Karlsquell Mocne'), 
    'Kwaśne jak hemoroidy lucyfera, tylko dla koneserów');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Szlacheckie Mocne'), 
    'Wracając dzisiaj wciąż jeszcze skacowany z pracy postanowiłem zakupić coś na kształt eliksiru many, który postawi mnie do pionu, bo było ciężko. Do wyboru miałem książa 9% i szlacheckie mocne. Padło na szlacheckie, bo nie piłem, a książa prędzej włożę sobie do jelit, niż do buzi. Puszka oczywiście żelazna jak to na porządne piwo przystało, no wyobrażacie sobie walkę aluminiowymi mieczami? Po dotarciu do domu oje**łem puszkę na strzała, nawet butów nie zdjąłem, bo suszyło. O dziwo podeszło mi mimo woltażu nędznego jak wzwód osiemdziesięciolatka, ale to może dlatego, że w tym momencie nawet denaturat smakował by jak Gout de Diamants. Jeb**ło też w czerep tak jakby sam Josef Mengele raczył mnie elektrowstrząsami przy okazji badając kiszkę stolcową wziernikiem zrobionym z ołowianej rynny i zardzewiałych grabi, ale to dlatego, że nic nie jadłem. Piwo faktycznie dla prawdziwych szlachciców, o ile jest to grupa meneli w którym szlachcicem nazywa się tego jedynego, który jeszcze nie zes*ał się pod siebie.');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Szlacheckie Mocne'), 
    'Stosunek jakość do ceny 6/10 faktycznie gorsze niż kuflowe ale na kacu mając 2 zł w portfelu bym nie pogardził');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Szlacheckie Mocne'), 
    'W smaku gorsze od Kuflowego, choć ten sam producent.');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Szlacheckie Mocne'), 
    'Nie dopiłem !');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Boorg Mocne'), 
    'piwo przy pierwszym smaku nabrało barw, niestety z każdym kolejnym łykiem co raz bardziej osadzał się posmak typowego gwoździa. Jako że nie miałem ochoty wypić go w jeden wieczór, na następny dzień lekko zaśmierdł, ani cienia gazu, nie do wypicia ale to moja wina. Ogólnie jak na taki woltaż to nie najgorsze, cena na plus.');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Boorg Mocne'), 
    'Lepszy był poker....chociaż niektorzy twierdzą że to to samo piwo tylko ze zmienioną nazwą');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Boorg Mocne'), 
    'Dziwny posmak jakby cebuli przy wypiciu wiecej niż jednego.');

INSERT INTO core."comments" (beer_id, "content") 
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Boorg Mocne'), 
    'Dziwny posmak. Jak ktoś już napisał: jakby brudny pies wpadł do piwa. Z colą da się wypić.');

-- RATES
INSERT INTO core.rates (beer_id, taste_rating, color_rating, aroma_rating)
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Beczkowe Mocne 9% Wiśnia'), 
    3, 
    1, 
    2);

INSERT INTO core.rates (beer_id, taste_rating, color_rating, aroma_rating)
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Beczkowe Mocne 9% Wiśnia'), 
    1, 
    2, 
    2);

INSERT INTO core.rates (beer_id, taste_rating, color_rating, aroma_rating)
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Halne Mocne'), 
    2, 
    3, 
    1);

INSERT INTO core.rates (beer_id, taste_rating, color_rating, aroma_rating)
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Halne Mocne'), 
    2, 
    3, 
    2);

INSERT INTO core.rates (beer_id, taste_rating, color_rating, aroma_rating)
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Piwny Bączek'), 
    1, 
    3, 
    3);

INSERT INTO core.rates (beer_id, taste_rating, color_rating, aroma_rating)
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Piwny Bączek'), 
    2, 
    1, 
    3);

INSERT INTO core.rates (beer_id, taste_rating, color_rating, aroma_rating)
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Jabłonowo Super Mocne'), 
    1, 
    1, 
    1);

INSERT INTO core.rates (beer_id, taste_rating, color_rating, aroma_rating)
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Jabłonowo Super Mocne'), 
    2, 
    1, 
    2);

INSERT INTO core.rates (beer_id, taste_rating, color_rating, aroma_rating)
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Special Mocne'), 
    2, 
    1, 
    2);

INSERT INTO core.rates (beer_id, taste_rating, color_rating, aroma_rating)
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Special Mocne'), 
    3, 
    3, 
    3);

INSERT INTO core.rates (beer_id, taste_rating, color_rating, aroma_rating)
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Karlsquell Mocne'), 
    5, 
    3, 
    5);

INSERT INTO core.rates (beer_id, taste_rating, color_rating, aroma_rating)
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Karlsquell Mocne'), 
    1, 
    4, 
    3);

INSERT INTO core.rates (beer_id, taste_rating, color_rating, aroma_rating)
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Szlacheckie Mocne'), 
    3, 
    4, 
    2);

INSERT INTO core.rates (beer_id, taste_rating, color_rating, aroma_rating)
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Szlacheckie Mocne'), 
    2, 
    2, 
    1);

INSERT INTO core.rates (beer_id, taste_rating, color_rating, aroma_rating)
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Boorg Mocne'), 
    3, 
    2, 
    2);

INSERT INTO core.rates (beer_id, taste_rating, color_rating, aroma_rating)
VALUES(
    (SELECT id FROM core.beers WHERE name = 'Boorg Mocne'), 
    2, 
    1, 
    3);
