USE AudioWave;

INSERT INTO Utente (email, password, nome, cognome, dataDiNascita, cellulare) VALUES ("email@gmail.com", sha2("password", 0), "Luca", "Rossi", "1995-05-07", "+39 33456765");
INSERT INTO Utente (email, password, nome, cognome, dataDiNascita, cellulare, ruolo) VALUES ("admin@gmail.com", sha2("admin", 0), "Admin", "Rossi", "1995-05-07", "+39 334534355", "admin");


INSERT INTO Categoria (nome) VALUES ("Cuffie");
INSERT INTO Categoria (nome) VALUES ("Auricolari");
INSERT INTO Categoria (nome) VALUES ("Speaker");


INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("WH-1000XM5", 'resources/images/WH-1000XM5.jpg', "Sony", "Le nostre comodissime cuffie WH-1000XM5 ridefiniscono il concetto di ascolto senza distrazioni e di chiarezza delle chiamate. Due processori controllano svariati microfoni per offrire Noise Cancelling senza precedenti, mentre Auto NC Optimizer ne migliora le prestazioni in base alle condizioni e all'ambiente d'uso. Il driver da 30 mm appositamente progettato offre una qualità audio superiore per tutto il tuo intrattenimento. Processore Noise Cancelling HD QN1, processore integrato V1 e microfoni multipli per un ascolto privo di distrazioni. Driver da 30 mm appositamente progettato per un suono eccezionale. Chiamate senza disturbi con 2x2 microfoni beamforming e sistema di riduzione del rumore (basato su IA). Ottimizzazione della pressione atmosferica e Noise Cancelling personalizzato completamente automatico. Design leggero e ultra confortevole in morbida pelle.", 420, 8, 22, 1);
INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("WH-XB910N", 'resources/images/WH-XB910N.jpg', "Sony", "Immergiti in un'esperienza musicale simile a quella di una discoteca grazie al Noise Cancelling migliorato e alla libertà wireless. Le cuffie Bluetooth sono comode da indossare e ti consentono di ascoltare la musica tutto il giorno, mentre ti tieni in contatto con gli amici grazie alla connessione multipoint e alla qualità delle chiamate cristallina. Sound EXTRA BASS e Digital Noise Cancelling. DSEE ripristina l'audio ad alta frequenza e in dissolvenza perso durante la compressione. Ascolto prolungato con una durata della batteria di 30 ore. Chiamate in viva voce semplici e assistente vocale con parola di attivazione. Libertà wireless con tecnologia Bluetooth & connessione multipoint.", 210, 10, 22, 1);
INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("WH-CH520", 'resources/images/WH-CH520.jpg', "Sony", "Progettate non solo per essere eleganti, ma anche facili da usare. Grazie al design leggero e ai padiglioni girevoli, indossare e rimuovere le cuffie è semplice, mentre l'archetto regolabile, l'imbottitura e i morbidi cuscinetti auricolari garantiscono comfort per tutto il giorno. Ascolta suoni di alta qualità tutto il giorno. Grazie a durata della batteria fino a 50 ore, connettività stabile e migliori prestazioni in termini di qualità delle chiamate, le cuffie WH-CH520 soddisfano ogni esigenza delle tue giornate. La tecnologia Digital Sound Enhancement Engine (DSEE) ripristina le armoniche e la vivacità perse in fase di compressione, per ottenere prestazioni più autentiche. Puoi perfino personalizzare la tua esperienza di ascolto con l'equalizzatore nell'app Sony | Headphones Connect. Per maggiore comodità, queste cuffie Bluetooth possono essere associate a due dispositivi Bluetooth contemporaneamente.", 59.89, 4, 22, 1);

INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("WI-C100", 'resources/images/WI-C100.jpg', "Sony", "Comode e facili da usare, le cuffie intrauricolari wireless WI-C100 associano batteria a lunga durata e ricarica rapida a un audio personalizzabile di alta qualità. Le cuffie sono resistenti all'acqua con un grado di protezione IPX4 e sono compatibili con l’app Sony | Headphones Connect. Fino a 25 ore di autonomia della batteria. DSEE ripristina le frequenze perse durante la compressione per produrre un audio di alta qualità più simile alla registrazione originale. Perfeziona il sound con l'app Sony | Headphones Connect. Resistente a sudore e spruzzi con classificazione IPX4. Chiamate in viva voce e assistente vocale.", 40, 2, 22, 2);
INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("WF-1000XM4", 'resources/images/WF-1000XM4.jpg', "Sony", "Esperienza di ascolto eccezionale e su misura. Gli auricolari True Wireless WF-1000XM4 portano il Noise Cancelling e la qualità audio avanzati a un livello superiore. Sono perfetti per qualsiasi tipologia di orecchio e si adattano a ogni situazione. Digital Noise Cancelling evoluto con processore integrato V1. Design ergonomico della superficie per una maggiore stabilità. Massima qualità con audio wireless ad alta risoluzione. Resistenti all'acqua e con maggiore autonomia per l'uso quotidiano. Ascolto intelligente e qualità delle chiamate nitida.",  280, 8, 22, 2);
INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("WF-1000XM3", 'resources/images/WF-1000XM3.jpg', "Sony", "Le cuffie completamene wireless WF-1000XM3 combinano eliminazione del rumore avanzata con un sound di alta qualità, funzioni di ascolto smart, connettività Bluetooth e NFC, una batteria che dura tutto il giorno e un comfort di ascolto prolungato. Processore HD QN1e di eliminazione digitale del rumore e tecnologia Dual Noise Sensor. Design True Wireless con tecnologia wireless BLUETOOTH. Fino a 24 ore durata della batteria per un ascolto che dura tutto il giorno. La funzione Rapida attenzione consente di parlare con le persone intorno a te con semplicità senza togliere le cuffie. Design classico dal tocco moderno che mantiene le cuffie perfettamente in posizione.", 250, 2, 22, 2);

INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("QuietComfort SE Headphones", 'resources/images/QuietComfort-SE-Headphones.jpg', "Bose", "Questo è il segreto delle Bose QuietComfort Headphones: una straordinaria combinazione di riduzione del rumore, prestazioni audio e comfort. E con l'equalizzazione regolabile per ottimizzare la musica secondo le tue preferenze, è amore al primo ascolto. La nostra tecnologia Acoustic Noise Cancelling, frutto di oltre 50 anni di ricerca, riduce i rumori esterni attraverso un segnale opposto, per ottenere più silenzio e ascoltare meglio la tua musica preferita. Puoi scegliere tra la modalità Silenzio, per una riduzione completa del rumore, e la modalità Suoni esterni udibili, per sentire una parte dei rumori ambientali. Con quattro microfoni esterni, le cuffie isolano e si concentrano sulla tua voce, mentre un algoritmo antirumore filtra i suoni ambientali per conversazioni più chiare anche in ambienti rumorosi o in presenza di vento. Il Bluetooth 5.1 offre una connessione potente e costante fino a 9 metri. Abbina fino a due dispositivi alla volta e passa facilmente dall'uno all'altro.", 189.99, 6, 22, 1);
INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("Noise Cancelling 700", 'resources/images/Noise-Cancelling-700.jpg', "Bose", "Riduzione del rumore avanzata e regolabile, con consapevolezza dell'ambiente per ascoltare ciò che ti sta intorno. Suono ad alta fedeltà con equalizzazione regolabile per ascoltare la musica secondo le tue preferenze. Acquisizione vocale impareggiabile per chiamate più nitide. E cuscinetti in pelle sintetica per offrire comfort giornaliero. Tutto ciò che desideri dalle cuffie Bluetooth wireless, amplificato. La nostra tecnologia proprietaria di riduzione del rumore attiva sfrutta i microfoni interni ed esterni ai padiglioni per monitorare i rumori ambientali e produrre immediatamente un segnale opposto che li elimina. Grazie alla riduzione del rumore regolabile, puoi controllare il livello di consapevolezza dei rumori esterni. Inoltre, la modalità conversazione ti consente di regolare contemporaneamente la riduzione del rumore e mettere in pausa la musica per una breve conversazione.", 215, 1, 22, 1);

INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("QuietComfort Earbuds II", 'resources/images/QuietComfort-Earbuds-II.jpg', "Bose", "I Bose QuietComfort Earbuds II sono auricolari wireless di nuova generazione. Suono straordinario e cancellazione del rumore perfetti per te. I morbidi cuscinetti e gli anelli stabilizzatori, disponibili in tre misure, offrono un comfort ideale. Puoi rilassarti al massimo nella Quiet Mode, che esclude il rumore di sottofondo grazie alla migliore cancellazione del rumore al mondo. Quando è il momento di prestare attenzione, l'Aware Mode ti consente di sentire l'ambiente circostante o di conversare piacevolmente. Mantieni alto il livello di energia per tutto il giorno grazie alle sei ore di autonomia di un'unica carica e alla custodia di ricarica che garantisce tre ricariche aggiuntive.", 279, 8, 22, 2);

INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("Galaxy Buds2 Pro", 'resources/images/Galaxy-Buds2-Pro.jpg', "Samsung", "Con 360 Audio Intelligent, il suono è più realistico. 360 Audio riesce addirittura ad identificare con estrema precisione la direzione del suono mentre muovi la testa, offrendoti un'esperienza spaziale. Passare alle conversazioni di persona è semplice grazie alla funzione Voice Detect. Grazie ai microfoni con un SNR (rapporto segnale/rumore) uguale a 3, i Galaxy Buds2 Pro tracciano ed eliminano più efficacemente il rumore circostante, anche i suoni più leggeri come quello del vento. Ti preoccupa l'eventualità di perdere i tuoi Galaxy Buds2 Pro? Tranquillo. Con SmartThings Find puoi tenere traccia dei tuoi amati Galaxy Buds2 Pro grazie alla funzione di localizzazione geografica.", 203, 4, 22, 2);
INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("Auricolari ANC Type-C", 'resources/images/Auricolari-ANC-Type-C.jpg', "Samsung", "Ascolta le tue playlist preferite con i nuovi auricolari Samsung dotati di Active Noise Cancelling e connettore di tipo C. Grazie alla loro incredibile capacità di schermare i rumori di fondo, potrai goderti la tua musica in qualsiasi situazione. Inoltre la porta USB tipo C divide nettamente il suono tra la cuffia destra e quella sinistra per un suono perfettamente bilanciato. Gli auricolari prendono energia dal dispositivo, perciò non dovrai caricarli separatamente. Ti basterà collegarli al telefono per un audio nitido e dinamico con poco rumore di fondo. Con un design ispirato a Galaxy Buds, sono progettati per adattarsi comodamente alle tue orecchie e sono perfetti per essere indossati tutto il giorno. I cuscinetti che trovi nella confezione danno dimensioni diverse ai diffusori, così potrai scegliere la misura che fa per te.", 20, 7, 22, 2);
INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("Auricolare a filo in-ear", 'resources/images/Auricolare-a-filo-in-ear.jpg', "Samsung", "Dotati di altoparlanti a 2 vie con subwoofer e tweeter dedicati per un audio uniforme, gli auricolari Samsung da 3,5 mm offrono un suono ricco, chiaro e bilanciato. Lasciati avvolgere dalle note musicali, mentre i toni alti, medi e bassi si intrecciano in modo equilibrato nelle tue orecchie. Progettato per essere all’altezza della sua qualità sonora, il design a canale ibrido degli auricolari da 3,5 mm eredita l’identità Samsung. Ogni auricolare è pensato per essere comodamente indossato, basta scegliere tra le opzioni incluse per una vestibilità perfetta.", 12, 6, 22, 2);
INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("Galaxy Buds Live", 'resources/images/Galaxy-Buds-Live.jpg', "Samsung", "Gli auricolari progettati per essere sempre sulla frequenza giusta. La loro forma iconica e il design ergonomico senza cuscinetti In-Ear, per non occludere il canale uditivo, insieme alla tecnologia di Cancellazione Attiva del Rumore, rendono l'esperienza di ascolto unica e comoda per tutta la giornata. Questo è il suono fatto apposta per le tue orecchie. Il design accattivante di Galaxy Buds Live si fa sempre notare, anche quando li indossi. Le linee seguono le curve dell'orecchio per un look naturale, la superficie è liscia e lucida e la custodia sembra un portagioie, perfetto per stare in tasca ovunque tu vada. Grazie alla tecnologia di Cancellazione Attiva dei Rumori (ANC), gli auricolari wireless Galaxy cancellano i rumori di fondo tenendoti sempre in contatto col mondo che ti circonda. Questo vuol dire che riducono le frequenze basse dei rumori fastidiosi, senza farti perdere quello che conta, come le voci delle persone o gli annunci.", 159, 8, 22, 2);

INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("MOMENTUM 4 Wireless", 'resources/images/MOMENTUM-4-Wireless.jpg', "Sennheiser", "Goditi la tua musica preferita come mai prima d'ora con il nostro sistema di trasduttori da 42 mm ispirati alle cuffie per audiofili che offre dinamica, chiarezza e musicalità senza pari. Con una batteria dall'eccezionale durata di 60 ore, funzioni intelligenti per la massima facilità d'uso e la struttura pieghevole per portarle ovunque, sono le compagne ideali per farsi accompagnare ovunque da un suono straordinario. La cancellazione adattiva del rumore di nuova generazione si adegua automaticamente al rumore ambientale, per restare sempre immersi nel suono e ascoltare meglio ogni dettaglio, anche in ambienti rumorosi. Continua ad ascoltare mentre giri per il mondo, con una durata della batteria fino a 60 ore e la possibilità di ricarica rapida che fornisce altre 6 ore di ascolto in soli 10 minuti. Il design leggero delle cuffie M4 è caratterizzato da un archetto imbottito e da padiglioni profondi e morbidi, per garantire un comfort eccezionale e a lungo.", 359, 4, 22, 1);
INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("Hd 400S", 'resources/images/Hd-400S.jpg', "Sennheiser", "HD 400S è una cuffia circumaurale chiusa e compatta compatta che garantisce un'esperienza d'ascolto ottima con una potente risposta nei bassi e riduzione del rumore ambientale. È dotata di un telecomando integrato in linea con un solo pulsante che permette di gestire in modo agevole chiamate e musica. I materiali e la costruzione di qualità garantiscono durabilità e performance, ciò che cerchi nella tua vita quotidiana. I trasduttori di precisione progettati in Germania garantiscono un suono dettagliato e dinamico con un equilibrio ottime ed un'ampia risposta dei bassi. Il telecomando integrato in linea consente con un solo comando di gestire musica e chiamate, senza dover mai toccare il telefono. Il design around-ear chiuso utilizza padiglioni ergonomici per ridurre il rumore ambientale e migliorare l'esperienza d'ascolto. L'archetto pieghevole permette di richiudere facilmente la cuffia per poterla riporre in modo pratico e portarla con sé ovunque.", 50, 8, 22, 1);
INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("HD 599", 'resources/images/HD-599.jpg', "Sennheiser", "La ottima arrivata nella Serie HD 500 spinge le performance audio ad un livello alto. Al topo della gamma di prodotto svetta la HD 599, una cuffia premium per coloro che ricercano un suono sofisticato, design e qualità costruttiva. Con la potenza dei trasduttori di tecnologia Sennheiser e con design 'Ergonomic Acoustic Refinement' (E.A.R), la HD 599 rappresenta un ottimo approccio nel mondo della riproduzione da audiofili. Una cuffia aperta circumaurale che garantisce un bilanciamento naturale dei toni ed una performance spaziale ottime. L'alto comfort è assicurato dalle dimensioni dei padiglioni, ricoperti da cuscinetti di velluto. I trasduttori Sennheiser utilizzano bobine in alluminio che assicurano alta efficienza, una dinamica ottime ed una distorsione bassa. Il design aperto circumaurale offre una presentazione spaziale 'aperta' per ottimizzare l'esperienza di ascolto.", 105, 8, 22, 1);

INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("CX 300S", 'resources/images/CX-300s.jpg', "Sennheiser", "La microcuffia Sennheiser CX 300S offre una riproduzione del suono dettagliata ed una risposta dei bassi migliorata grazie alla tecnologia dei trasduttori di Sennheiser. I comandi intelligenti consentono di mettere in pausa la musica e di gestire le chiamate attraverso i dispositivi. Il trasduttore 18-ohm garantisce compatibilità con smartphone, tablet e computer. I trasduttori di precisione progettati in Germania garantiscono un suono dettagliato e dinamico con un equilibrio ottime ed un'ampia risposta dei bassi. Il telecomando integrato in linea consente con un solo comando di gestire musica e chiamate, senza dover mai toccare il telefono. Gli adattatori auricolari in silicone in quattro diverse misure (XS, S, M, L) permettono di personalizzare la vestibilità assicurando comfort e performance ottimali. Il design in-ear blocca in modo efficace il rumore ambientale migliorando l'esperienza d'ascolto.", 29, 5, 22, 2);
INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("CX 80S", 'resources/images/CX-80S.jpg', "Sennheiser", "Le cuffie in-ear Sennheiser CX 80S offrono qualità e prestazioni eccellenti. Il suono, nitido e ben bilanciato, è caratterizzato da una risposta omogenea alle frequenze e da bassi profondi. Il design è leggero e minimale per il massimo comfort. Inoltre, il set incluso di adattatori auricolari in tre diverse misure (S, M, L) assicura una tenuta perfetta, in grado di bloccare efficacemente i rumori ambientali. I trasduttori di precisione progettati in Germania garantiscono un suono dettagliato e dinamico con un equilibrio ottime ed un'ampia risposta dei bassi. Il telecomando integrato in linea consente con un solo comando di gestire musica e chiamate, senza dover mai toccare il telefono. Gli adattatori auricolari in silicone in tre diverse misure (S, M, L) permettono di personalizzare la vestibilità assicurando comfort e performance ottimali. Il design in-ear blocca in modo efficace il rumore ambientale migliorando l'esperienza d'ascolto.", 19, 6, 22, 2);
INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("CX True Wireless", 'resources/images/CX-True-Wireless.jpg', "Sennheiser", "I nuovi auricolari CX True Wireless offrono un suono cristallino con bassi profondi che potete facilmente regolare in base ai vostri gusti personali. Grazie al design ergonomico che garantisce il massimo comfort e ai comandi intuitivi che ne facilitano l'uso, l'esperienza di ascolto è di prim'ordine. Goditi i tuoi brani preferiti al massimo con il trasduttore TrueResponse, realizzato su misura, per un suono cristallino ovunque e in qualsiasi momento. Con l'aggiunta della funzione Bass Boost e l'attivazione dell'equalizzatore integrato tramite l'app Smart Control, potrai avere il suono che preferisci. Dimentica l'ambiente circostante con la cancellazione passiva del rumore e immergiti nella musica o concentrati sulla tua chiamata. L'accattivante design ergonomico assicura un ottimo comfort di utilizzo. Grazie agli adattatori auricolari di 4 misure, è facile ottenere un'aderenza perfetta per qualsiasi attività.", 70, 3, 22, 2);


INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("JBL Live Flex", 'resources/images/JBL-LIVE-FLEX.jpg', "JBL", "Vivi al ritmo della tua colonna sonora personale grazie agli auricolari open-ear con cancellazione del rumore adattiva, progettati per un comfort che dura tutto il giorno e un ascolto in movimento ad alta fedeltà. Dall’ufficio alla tua passeggiata quotidiana e oltre, gli auricolari JBL Live Flex impermeabili e antipolvere certificati IP54 sono ideali per lavorare, riposare o giocare. Elimina il rumore e le distrazioni ed effettua chiamate cristalline ovunque, il tutto immergendoti nell’audio spaziale JBL. Ottimizza la tua esperienza di ascolto in base al tuo profilo uditivo individuale grazie a Personi-Fi 2.0 e alle preferenze tramite l’app. E poiché nessuno ama avere le batterie scariche, fino a 40 ore di riproduzione e ricarica wireless Qi ti offrono un movimento al ritmo della tua vita.", 170, 6, 22, 2);
INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("JBL Tune Beam", 'resources/images/JBL-Tune-Beam.jpg', "JBL", "Affronta la tua giornata un brano dopo l’altro con JBL Tune Beam. Questi auricolari True Wireless ti offrono fino a 48 ore di suono JBL Pure Bass eccezionale, mentre il design ergonomico, impermeabile e resistente alla polvere ti assicura comfort per tutto il giorno in qualsiasi condizione meteo. Un semplice tocco consente di gestire e ricevere chiamate perfette ovunque, senza rumori ambientali. E con la tecnologia di cancellazione attiva del rumore e Smart Ambient, puoi scegliere se desideri ignorare il mondo attorno a te o interagire con l’ambiente circostante. Il design stick-closed garantisce vestibilità sicura e isolamento dal rumore esterno per prestazioni sonore migliori. Ma soprattutto, l’app JBL Headphones ti consente di personalizzare l’intera esperienza di ascolto. Rimani connesso con il tuo mondo, a modo tuo.", 95, 5, 22, 2);
INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("JBL T290", 'resources/images/JBL-T290.jpg', "JBL", "Ecco le cuffie intra-auricolari JBL T290 con suono JBL Pure Bass. Sono leggere, comode e compatte. Dentro il corpo in alluminio degli auricolari, una coppia di driver da 8,7mm riproduce bassi profondi, emettendo il potente suono JBL Pure Bass che hai ascoltato nelle sale da concerto, negli stadi e negli studi di registrazione in tutto il mondo. Inoltre, un comando ad un pulsante consente di controllare la riproduzione musicale, così come il microfono incorporato permette di rispondere alle telefonate in tempo reale, rendendo le JBL T290 le tue compagne ideali per il lavoro, a casa ed in viaggio.", 25, 4, 22, 2);


INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("JBL Tour One M2", 'resources/images/JBL-TOUR-ONE-M2.jpg', "JBL", "La tecnologia di cancellazione del rumore True Adaptive di JBL Tour One M2 elimina le distrazioni per farti godere le tue playlist preferite, o persino il suono del silenzio, il tutto grazie al leggendario JBL Pro Sound certificato ad alta risoluzione. Immergiti in uno straordinario audio spaziale in movimento fino a 50 ore o goditi la nitidezza della tecnologia a 4 microfoni durante le conversazioni telefoniche. Grazie alla funzione Smart Talk, i microfoni integrati riconoscono la tua voce, così potrai avviare conversazioni rapide con le cuffie accese. Attiva l'amplificazione del suono personale per aumentare il volume vocale tuo e degli altri senza mai rimuovere le cuffie.", 310, 4, 22, 1);
INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("JBL Tune 770NC", 'resources/images/JBL-TUNE-770NC.jpg', "JBL", "Quando puoi ascoltare la tua musica, nient'altro ha importanza. Le cuffie wireless con cancellazione del rumore adattiva JBL Tune 770NC mantengono questa promessa tutto il giorno, e più a lungo, risparmiandoti i rumori indesiderati. Con una durata della batteria fino a 70 ore, potrai utilizzarle per tutta la settimana senza problemi e avere ancora abbastanza suono JBL Pure Bass per il fine settimana. E se hai bisogno di una ricarica rapida, in 5 minuti otterrai 3 ore di musica in più. Leggere e pieghevoli, le cuffie JBL Tune 770NC possono anche essere connesse a due dispositivi Bluetooth contemporaneamente, in modo da non perdere mai una chiamata mentre guardi un film sul tuo tablet. Con l'app gratuita JBL Headphones, puoi personalizzare il suono in base ai tuoi gusti. E i prompt vocali nella tua lingua ti guideranno attraverso le funzioni. Gestisci le chiamate e l'assistente vocale senza problemi direttamente dal tuo telefono, e utilizza la funzione VoiceAware per sentire la tua voce quando parli. Basta scegliere il colore che meglio si adatta alla tua atmosfera e iniziare a divertirsi.", 110, 5, 22, 1);
INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("JBL TUNE 500", 'resources/images/JBL-TUNE-500.jpg', "JBL", "Le JBL TUNE500 offrono un potente suono di qualità per ravvivare la tua giornata. Dotate di suono JBL Pure Bass, driver JBL da 32 mm e di telecomando universale con un pulsante compatibile con la maggior parte degli smartphone, queste cuffie offrono un'esperienza d'ascolto magnifica ogni volta. Leggere e comode grazie ai morbidi cuscinetti auricolari e all'archetto imbottito, le cuffie JBL TUNE500 ti permettono inoltre di connetterti a Siri o Google Now senza usare il tuo cellulare. Disponibili in 4 nuovi colori, dotate di cavo piatto anti-groviglio e pieghevoli per seguirti ovunque, le cuffie JBL TUNE500 sono una soluzione semplice e portatile per aggiungere un sottofondo musicale a ogni aspetto della tua vita impegnata.", 25, 4, 22, 1);


INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("JBL Xtreme 3", 'resources/images/JBL-XTREME-3.jpg', "JBL", "Scatena la potenza del suono, ovunque ti trovi. In piscina. A un pic-nic. In giro. Non c'è festa senza musica. Il diffusore portatile Bluetooth JBL Xtreme 3 con JBL Original Pro Sound offre un audio potente grazie a quattro driver e due JBL Bass Radiator. Inoltre, con PartyBoost, puoi connettere più diffusori compatibili per un sound superiore. La pioggia è una guastafeste, ma Xtreme 3 è waterproof e dustproof, e la pratica tracolla per il trasporto con apribottiglie incorporato ti permette di spostarti rapidamente al chiuso. JBL Xtreme 3 fa colpo ovunque ti trovi.", 310, 8, 22, 3);
INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("JBL Flip Essential 2", 'resources/images/JBL-Flip-Essential-2.jpg', "JBL", "Tutto il sorprendente piacere del potente suono stereo avvolgente del diffusore Bluetooth portatile ultracompatto JBL Flip Essential. Alimentato da una batteria agli ioni di litio ricaricabile da 3000 mAh, garantisce 10 ore di riproduzione ininterrotta di alta qualità. L'esterno, caratterizzato da una struttura impermeabile e da un tessuto resistente, è classificato IPX7. Sulla scrivania o a bordo piscina, nelle mattine di sole o nelle nottate piovose, Flip Essential è il miglior compagno multifunzione e resistente alle intemperie. Il doppio radiatore passivo esterno produce un suono JBL potente e accattivante, che risulta forte e definito, consentendoti di sentire, percepire e vedere i bassi. I tessuti durevoli e il robusto rivestimento in gomma rendono il tuo diffusore a prova di qualsiasi avventura.", 100, 4, 22, 3);
INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("JBL BOOMBOX 3 WI-FI", 'resources/images/JBL-BOOMBOX-3-WI-FI.jpg', "JBL", "Lo speaker JBL Boombox 3 Wi-Fi e Bluetooth offre il potente suono JBL Original Pro con i bassi più profondi che si siano mai sentiti su uno speaker portatile. Riproduci musica in streaming ad alta definizione ovunque con JBL Boombox 3, grazie a Dolby Atmos 3D e al Wi-Fi. Devi rispondere a una chiamata o scorrere il feed? Fallo senza problemi: la tua musica non si interromperà. Passa facilmente al Bluetooth e continua a goderti un'esperienza audio senza interruzioni al chiuso e all'aperto. Con una batteria in grado di offrire 24 ore di riproduzione e un design waterproof e antipolvere, sei sempre pronto per qualsiasi avventura. Riproduci la tua musica in streaming con AirPlay, Alexa Multi-Room Music, Chromecast built-in e Spotify Connect. Goditi tutti i tuoi contenuti audio, radio e podcast online preferiti in alta definizione. Ovunque tu vada, i materiali ecologici, che incorporano plastica e tessuto riciclati, contribuiscono a rendere il mondo un posto più verde.", 589, 3, 22, 3);
INSERT INTO Prodotto (nome, immagine, marca, descrizione, prezzo, disponibilita, IVA, categoriaID) VALUES("JBL GO 3 ECO", 'resources/images/JBL-GO-3-ECO.jpg', "JBL", "JBL Go 3 è caratterizzato da uno stile grintoso e dall’entusiasmante JBL Pro Sound. Dotato di un design moderno che non passa inosservato, tessuti variopinti e inserti vivaci, è un must di cui non puoi fare a meno. Grazie al JBL Pro Sound, i tuoi brani ti porteranno sul tetto del mondo, mentre il suo design certificato waterproof e dustproof IP67 ti permetterà di goderti la tua musica in qualsiasi condizione meteo e, grazie al suo laccetto integrato, potrai portarlo ovunque. Go 3 è caratterizzato da nuove tonalità e combinazioni cromatiche ispirate allo street style del momento. JBL Go 3 è audace nell'aspetto e nel suono.", 44, 5, 22, 3);
