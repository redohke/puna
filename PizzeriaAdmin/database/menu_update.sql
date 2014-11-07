/* 	
	Kohta 1 = taulun nimi mihin halutaan muutoksia (esim pizza)
	Kohta 2 = taulun alue mihin halutaan muutoksia (esim hinta)
	Kohta 3 = Muutos mit‰ halutaan tehd‰ (esim uusi hinta) 
		->t‰ss‰ kohdassa jos halutaan piilottaa jokin tuote n‰kyvilt‰ lisotilta k‰ytet‰‰n joko 1 = n‰kyy tai 0 = piilotetaan
	Kohta 4 = muutettavan objektin id (esim 1)

*/


update (1) set (2) = '(3)' where id = (4);



/*
 Esimerkki: Piilotetaan ensimm‰inen pizza listaltamme:
 
 	update pizza set tarjolla = '0'  where id = (1);

*/


