%Jackie Gan
%MATH 3044
%Homework12_2, Parabolic Partial Differential Equations
%Q5a
format long

close all
clear
clc

%Forward difference method, Q5a
Freal = @(x,t)exp(-4*pi*pi*t)*sin(2*pi*x);
hreal = 0.4;
kreal = 0.05;

h = 0.4;
k = 0.1;
t= 0.5;