%% lab work 1 - Chapter 1, Section 1.2
%% Example 1 & solution
% (a) Given a number a, first change it to 0.d1d2d3...*10^m
% then write functions of chopping/rounding to n<=6 digits based on floor()/ round() functions in Matlab/Octave
% (b) Do finite-digit arithmetic 
% x(+)y; x(-)y; x(*)y; x(/)y

global n
n = 6; % n is the number of digits

% num = 153.6264517392; % this is a given number for testing
num = 0.06264517392; % this is a given number for testing

% num1 = flc(num);
% fprintf("%s %d %s %.10f \n","chopping to ",n," digits: ",num1)
% num1 = flr(num);
% fprintf("%s %d %s %.10f \n","rounding to ",n," digits: ",num1)

a = pi;  %used to calculate 
b = 10/3;%used to calculate 

% fprintf("%s %d %s %.10f \n","chopping to ",n," digits: a (+) b =  ",flc( flc(a)+flc(b)))
% fprintf("%s %d %s %.10f \n","chopping to ",n," digits: a (-) b =  ",flc( flc(a)-flc(b)))
% fprintf("%s %d %s %.10f \n","chopping to ",n," digits: a (*) b =  ",flc( flc(a)*flc(b)))
% fprintf("%s %d %s %.10f \n","chopping to ",n," digits: a (/) b =  ",flc( flc(a)/flc(b)))
% 
% fprintf("%s %.10f \n",'relative error for chopping a (+) b is: '...
%     ,abs( flc( flc(a)+flc(b) ) - (a+b) )/abs(a+b))
% fprintf("%s %.10f \n",'relative error for chopping a (-) b is: '...
%     ,abs( flc( flc(a)-flc(b) ) - (a-b) )/abs(a-b))
% fprintf("%s %.10f \n",'relative error for chopping a (*) b is: '...
%     ,abs( flc( flc(a)*flc(b) ) - (a*b) )/abs(a*b))
% fprintf("%s %.10f \n",'relative error for chopping a (/) b is: '...
%     ,abs( flc( flc(a)/flc(b) ) - (a/b) )/abs(a/b))
% 
% fprintf("%s %d %s %.10f \n","rounding to ",n," digits: a (+) b =  ",flr( flr(a)+flr(b)))
% fprintf("%s %d %s %.10f \n","rounding to ",n," digits: a (-) b =  ",flr( flr(a)-flr(b)))
% fprintf("%s %d %s %.10f \n","rounding to ",n," digits: a (*) b =  ",flr( flr(a)*flr(b)))
% fprintf("%s %d %s %.10f \n","rounding to ",n," digits: a (/) b =  ",flr( flr(a)/flr(b)))
% 
% fprintf("%s %.10f \n",'relative error for rounding a (+) b is: '...
%     ,abs( flr( flr(a)+flr(b) ) - (a+b) )/abs(a+b))
% fprintf("%s %.10f \n",'relative error for rounding a (-) b is: '...
%     ,abs( flr( flr(a)-flr(b) ) - (a-b) )/abs(a-b))
% fprintf("%s %.10f \n",'relative error for rounding a (*) b is: '...
%     ,abs( flr( flr(a)*flr(b) ) - (a*b) )/abs(a*b))
% fprintf("%s %.10f \n",'relative error for rounding a (/) b is: '...
%     ,abs( flr( flr(a)/flr(b) ) - (a/b) )/abs(a/b))

%% Example 2 (This is lab work 1. Write the code between "
%% solution for Example 2" and "%% end of Example 2" then submit it via canvas)
% (a) Given a polynomial p(x) = m*x^m+(m-1)*x^(m-1)+ ... +1*x+pi/4, m = 100,
% write the code to use nested form computing p( pi/3 ) and p( sin(pi/40) )
% by chopping/rounding to six digits
% (use the finite digit arithmetic functions in Example 1)
% (b) Calculate the absolute error and relative error

%% solution for Example 2

x = pi/3;
y = sin(pi/40);
xC = flc(pi/3);
yC = flc(sin(pi/40));
v = [0:1:100];

%without nesting
% fprintf("%s %.10f\n","exact answer p( pi/3 ) =  ",exact(x))
% fprintf("%s %.10f\n","Chopped answer p( pi/3 ) =  ",chopped(x))
% fprintf("%s %.10f\n","Rounded answer p( pi/3 ) =  ",rounded(x))
% fprintf("%s %.10f %s %.10f\n", "absolute error by chopping", abs(exact(x)-chopped(x)) ,...
% "absolute error by rounding",abs(exact(x)-rounded(x)));
% fprintf("%s %.10f %s %.10f\n", "relative error by chopping", abs(exact(x)-chopped(x))/abs(exact(x)) ,...
% "relative error by rounding",abs(exact(x)-rounded(x))/abs(exact(x)));
% fprintf("%s %.10f\n","exact answer p( sin(pi/40) ) =  ",exact(y))
% fprintf("%s %.10f\n","Chopped answer p( sin(pi/40))  =  ",chopped(y))
% fprintf("%s %.10f\n","Rounded answer p( sin(pi/40))  =  ",rounded(y))
% fprintf("%s %.15f %s %.15f\n", "absolute error by chopping", abs(exact(y)-chopped(y)) ,...
% "absolute error by rounding",abs(exact(y)-rounded(y)));
% fprintf("%s %.15f %s %.15f\n", "relative error by chopping", abs(exact(y)-chopped(y))/abs(exact(y)) ,...
% "relative error by rounding",abs(exact(y)-rounded(y))/abs(exact(y)));

a = Hexact(x,v);
b = Hchopped(x,v);
c = Hrounded(x,v);

d = Hexact(y,v);
e = Hchopped(y,v);
f = Hrounded(y,v);

fprintf("\n%s\n","the nested version");
%nested version
fprintf("%s %.10f\n","horner exact answer p( pi/3 ) =  ", a)
fprintf("%s %.10f\n","horner Chopped answer p( pi/3 ) =  ",flc(b))
fprintf("%s %.10f\n","horner Rounded answer p( pi/3 ) =  ",flr(c))
fprintf("%s %.10f %s %.10f\n", "Horner absolute error by chopping", abs(a-flc(b)) ,...
"Horner absolute error by rounding",abs(a-flr(c)));
fprintf("%s %.10f %s %.10f\n", "Horner relative error by chopping", abs(a-flc(b))/abs(a) ,...
"Horner relative error by rounding",abs(a-flr(c))/abs(a));
fprintf("%s %.10f\n","Horner exact answer p( sin(pi/40) ) =  ",d)
fprintf("%s %.10f\n","Horner Chopped answer p( sin(pi/40))  =  ",flc(e))
fprintf("%s %.10f\n","Horner Rounded answer p( sin(pi/40))  =  ",flr(f))
fprintf("%s %.15f %s %.15f\n", "Horner absolute error by chopping", abs(d-flc(e)) ,...
"Horner absolute error by rounding",abs(d-flr(f)));
fprintf("%s %.15f %s %.15f\n", "Horner relative error by chopping", abs(d-flc(e))/abs(d) ,...
"Horner relative error by rounding",abs(d-flr(f))/abs(d));

function out = Hexact(b,coefficients)
    answer = 0;
    for i = (numel(coefficients):-1:1)
        answer = (answer * b) + coefficients(i);
    end
    out = answer + pi/4;
end

function out = Hchopped(b,coefficients)
    answer = 0;
    for i = (numel(coefficients):-1:1)
        answer = flc(flc(answer * flc(b)) + flc(coefficients(i)));
    end
    out = answer + flc(pi/4);
end

function out = Hrounded(b,coefficients)
    answer = 0;
    for i = (numel(coefficients):-1:1)
        answer = flr(flr(answer * flr(b)) + flr(coefficients(i)));
    end
    out = answer + flr(pi/4);
end

function out = exact(in)
    answer = 0;
    for v=1:100
        answer = answer + (v*(in^v));
    end
    out = answer + (pi/4);
end

function out = chopped(in)
    answer = 0;
    in = flc(in);
    for v=1:100
        answer = answer + flc(v*flc(in^v));
    end
    out = flc(answer + flc(pi/4));
end

function out = rounded(in)
    answer = 0;
    in = flr(in);
    for v=1:100
        answer = answer + flr(v*flr(in^v));
    end
    out = flr(answer + flr(pi/4));
end




%% end of Example 2

%% functions of chopping and rounding for Example 1 & 2

function num = flc(num) 
% chopping to n digits
global n
n=6;

tmp = floor(num);
i=0;
if tmp>0
    while(floor(tmp/10)>0)
        tmp = floor(tmp/10);
        i = i+1;
    end
    num = num/10^(i+1);
    num = floor(num*10^n)/10^n;
    num = num*10^(i+1);
elseif tmp == 0 && num ~= 0
    tmp = num;
    while(floor(tmp*10)==0)
        tmp = tmp*10;
        i = i+1;
    end
    num = num*10^(i);
    num = floor(num*10^n)/10^n;
    num = num/10^(i);
end

end

function num = flr(num)
% rounding to n digits
global n

tmp = floor(num);
i=0;
if tmp>0
    while(floor(tmp/10)>0)
        tmp = floor(tmp/10);
        i = i+1;
    end
    num = num/10^(i+1);
    num = round(num*10^n)/10^n;
    num = num*10^(i+1);
elseif tmp == 0 && num ~= 0
    tmp = num;
    while(floor(tmp*10)==0)
        tmp = tmp*10;
        i = i+1;
    end
    num = num*10^(i);
    num = round(num*10^n)/10^n;
    num = num/10^(i);
end

end