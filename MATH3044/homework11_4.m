%Jackie Gan
%MATH 3044
%Homework11.4 using newton's method

format long

close all
clear
clc

f = @(y) 2*y^3;
df = @(y) 6*y^2;
y0 = 1/3;

newton(f,df,y0,100)

function newton(f,df,y0,n)
    y(1) = y0;
    error = 10;
    for i = 1:n
        y(i+1) = y(i) - (f(y(i)) / df(y(i)));
    end
%     while error > 1*10^-8
%         i=1;
%         y(i+1) = y(i) - (f(y(i)) / df(y(i)));
%         error = abs(y(i+1) - y(i));
%         i=i+1;
%     end
    disp(y)
end
