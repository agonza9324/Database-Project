insert into Employee values('e001','Jose','De La Rosa', 1993/12/17);
insert into Employee values('e002','William','McComas', 1993/2/24);
insert into Employee values('e003','Mark','Chlan', 1993/12/18);
insert into Employee values('e004','Stephen','Stevens', 1989/3/9);
insert into Employee values('m001','Dave','Smith', 1978/1/1);
insert into Employee values('m002','Dan','Enslin', 1980/4/5);
insert into Employee values('m003','Dan','Tinker', 1982/8/12);
insert into Employee values('m004','Matt','Thrasher', 1981/11/20);
insert into Employee values('m005','Mike','Siefert', 1982/5/15);
insert into Employee values('m005','Doug','Ziemba', 1994/2/16);


insert into Truck values('t01', 500000, 26, 'registration_t01',null);
insert into Truck values('t02', 500000, 27, 'registration_t02',null);
insert into Truck values('t03', 500000, 27, 'registration_t03',null);
insert into Truck values('t04', 500000, 26, 'registration_t04',null);
insert into Truck values('t05', 500000, 26, 'registration_t05',null);
insert into Truck values('r01', 3000, 26, 'registration_r01',null);
insert into Truck values('r02', 5000, 26, 'registration_r02',null);


insert into Client values('c01', 'John', 'Shmoe', '443-111-1111');
insert into Client values('c02', 'Jane', 'Doe', '443-222-1111');
insert into Client values('c03', 'Sarah', 'lynn', '443-333-1111');
insert into Client values('c04', 'Dave', 'Fitz', '443-444-1111');
insert into Client values('c05', 'Muhammad', 'Ali', '443-555-1111');


insert into Job values('j001', 'address, Timmonium, MD 21093', 'address, Towson, MD 21212', 8, 2000.00, 2019/4/22, 'c01', 'move');
insert into Job values('j002_1', 'address, Timmonium, MD 21093', null, 8, 1000.00, 2019/4/23, 'c02', 'pack');
insert into Job values('j002_2', 'address, Timmonium, MD 21093', 'address, Towson, MD 21212', 8, 2000.00, 2019/4/24, 'c02', 'move');
insert into Job values('j003_1', 'address, Bel Air, MD 21014', null, 5, 800.00, 2019/4/23, 'c03', 'pack');
insert into Job values('j003_2', 'address, Bel Air, MD 21014', 'address, Towson, MD 21212', 8, 2000.00, 2019/4/24, 'c03', 'move');
insert into Job values('j004', 'address, Towson, MD 21212', 'address, Raleigh, NC 27513', 20, 5000.00, 2019/4/25, 'c04', 'move');
insert into Job values('j005_1', 'address, Baltimore, MD 21212', 'Self-Storage Plus', 6, 1800.00, 2019/4/25, 'c05', 'move->storage');
insert into Job values('j005_2', 'Self-Storage Plus', 'address, Baltimore, MD 21212', 6, 1800.00, 2019/4/26, 'c05', 'storage->move');


insert into JobTrucks values('j001', 't01');
insert into JobTrucks values('j002_1', 't02');
insert into JobTrucks values('j002_2', 't02');
insert into JobTrucks values('j003_1', 't03');
insert into JobTrucks values('j003_2', 't03');
insert into JobTrucks values('j004', 't04');
insert into JobTrucks values('j004', 't05');
insert into JobTrucks values('j005_1', 'r01');
insert into JobTrucks values('j005_2', 'r02');


insert into JobEmps values('j001', 'm005');
insert into JobEmps values('j001', 'e001');
insert into JobEmps values('j001', 'e004');

insert into JobEmps values('j002_1', 'm001');
insert into JobEmps values('j002_1', 'e003');
insert into JobEmps values('j002_1', 'e002');

insert into JobEmps values('j002_2', 'm001');
insert into JobEmps values('j002_2', 'e002');
insert into JobEmps values('j002_2', 'e003');
insert into JobEmps values('j002_2', 'e004');

insert into JobEmps values('j003_1', 'm002');
insert into JobEmps values('j003_1', 'e001');

insert into JobEmps values('j003_2', 'm002');
insert into JobEmps values('j003_2', 'e001');
insert into JobEmps values('j003_2', 'm005');

insert into JobEmps values('j004', 'm004');
insert into JobEmps values('j004', 'e004');
insert into JobEmps values('j004', 'e002');
insert into JobEmps values('j004', 'e003');
insert into JobEmps values('j004', 'e001');

insert into JobEmps values('j005_1', 'm001');
insert into JobEmps values('j005_1', 'e004');
insert into JobEmps values('j005_1', 'e001');
insert into JobEmps values('j005_1', 'e002');
insert into JobEmps values('j005_1', 'e003');

insert into JobEmps values('j005_2', 'm001');
insert into JobEmps values('j005_2', 'e004');
insert into JobEmps values('j005_2', 'e001');
insert into JobEmps values('j005_2', 'e002');
insert into JobEmps values('j005_2', 'e003');


insert into StorageUnit values(0001, 'Self-Storage PLus', 200, '10x10', 'c05');


insert into PaysFor values('c01', 'j001', null, null);
insert into PaysFor values('c02', 'j002_1', null, null);
insert into PaysFor values('c02', 'j002_2', null, null);
insert into PaysFor values('c03', 'j003_1', null, null);
insert into PaysFor values('c03', 'j003_2', null, null);
insert into PaysFor values('c04', 'j004', null, null);
insert into PaysFor values('c05', 'j005_1', null, null);
insert into PaysFor values('c05', 'j005_2', null, null);


