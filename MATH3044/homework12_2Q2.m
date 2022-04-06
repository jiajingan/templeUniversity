%Jackie Gan
%MATH 3044
%Homework12_2, Parabolic Partial Differential Equations
%Q2, 5a
format long

close all
clear
clc

%Backward difference methods, Q2
Freal = @(x,t)2*exp(-1*(pi^2/4)*t)*sin(2*pi*x);
ut0 = 0; ut1 = 0;
ux =@(x) 2*sin(2*pi*x);
m=3; T=0.1; N=2;
