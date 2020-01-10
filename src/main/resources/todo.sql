#20190302
alter table custcase
  add column priority int default 0;


#20190223
alter table custcase
  drop column banner;
alter table custcase
  add column banners varchar(5000);

alter table custcase
  add column settop tinyint(4) default 2;

alter table custcase
  add column top_intro varchar(500);

alter table custcase
  add column top_img varchar(1024);
