files = dir('*.txt');
[tam noUse] = size(files);
for i = 1:tam
    file = files(i).name;
    data = load(file);
    saveas(mesh(data),strcat(file,'.jpg'),'jpg');
end