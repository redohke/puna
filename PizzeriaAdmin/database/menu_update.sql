/* 	
 	pizzan piilottaminen: set tarjolla = '0'
 	pizzan näkyminen: set tarjolla = '1'
 	juoman piilottaminen: set tarjolla = '0'
 	juoman näkyminen: set tarjolla = '1'
*/
update pizza set tarjolla = ''  where id = (pizzan id);

update juoma set tarjolla = '' where id = (juoma id);

update juoma set nimi = 'Maito 1,0 l' where id = 7;

