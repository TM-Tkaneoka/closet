INSERT IGNORE INTO category (category_id,category_name)
VALUES("トップス"),("アウター"),("ボトムス"),("ワンピース"),("小物");
INSERT IGNORE INTO sub_category (sub_category_id,category_id,sub_category_name)
VALUES(1,"シャツ/ブラウス/カットソー"),(1,"ニット"),(1,"パーカー/スウェット"),(2,"ジャケット"),(2,"コート"),(2,"ブルゾン"),(3,"パンツ"),(3,"スカート"),(4,"ワンピース"),(4,"サロペット"),(4,"オールインワン"),(5,"帽子"),(5,"バッグ"),(5,"シューズ");

INSERT IGNORE INTO users (id,user_id,password,gender,born_year,admin_key,area_id)
    VALUES('1','YAMAMOTO','aaaaa','男',19960806,111,1996);
INSERT IGNORE INTO items (item_id,category_id,sub_category_id,season_id,color_id,id,picture,
                          coment,created_at,updated_at);
    VALUES('1',1,1,1,1,1, 'picture',"メモ","2019-06-17", "2019-06-17")
INSERT IGNORE INTO areas (area_id,area_name,longitude,latitude)
    VALUES('1', 'area', 15, 15);
INSERT IGNORE INTO calender (calender_id,id,coordinate_id,event,event_date,met_person)
    VALUES('1', 1, 1,'event', "2019-06-17", met_person);
INSERT IGNORE INTO coordinate (coordinate_id,id,coordinate_title,coment,created_at,updated_at)
    VALUES('1', 1,'title', "coment", "2019-06-17", "2019-06-17", 1);
INSERT IGNORE INTO coordinate_choice (coordinate_id,item_id)
    VALUES(1,1);
INSERT IGNORE INTO season (season_id,season_name)
    VALUES("春"),("夏"),("秋"),("冬"),("春夏",("秋冬"),("ALL SEASON");
INSERT IGNORE INTO color (color_id,color_name)
VALUES("ホワイト"),("ブラック"),("グレー"),("ブラウン"),("ベージュ",("グリーン"),("ブルー"),("パープル"),("イエロー"),("ピンク"),("レッド"),("オレンジ"),("シルバー"),("ゴールド"),("その他");