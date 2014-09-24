/*pizzan taytteet ulos */
select ta.nimi
from taytepizza t
join pizza p
on t.pizza_id = p.id
join tayte ta
on ta.id = t.tayte_id
where p.id = 2;