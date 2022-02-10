
%determine all the values 
p0=0.8;
p1=0.7;
a=0.3;
b=1;
p=0.8;
p2=0;

%determine the iteration
n = ceil(log2((b-a)/10^(-10))) - 1;

%creating a vector to calculate the results for convergence
x1 = zeros(1, n);
x2 = zeros(1, n);
x3 = zeros(1, n);
x4 = zeros(1, n);

[x1,f1] = bisection(n,x1,a,b);
[x2,f2] = newton(n,x2,p);
[x3,f3] = secant(n,p0,p1,x3,p2);
[x4,f4] = FuncModifiedNewton(n,x4,p);

%checking for errors to find difference between p and result
error1 = abs(x1-f1);
error2 = abs(x2-f2);
error3 = abs(x3-f3);
error4 = abs(x4-f4);

fprintf("results\n");
fprintf("%s %.10f %s %.10f \n", "Newton function: f(", f2, ") = ", myFunc(f2));
fprintf("%s %.10f %s %.10f \n", "Bisection function: f(", f1, ") = ", myFunc(f1));
fprintf("%s %.10f %s %.10f \n", "Secant function: f(", f3, ") = ", myFunc(f3));
fprintf("%s %.10f %s %.10f \n\n", "Modified Newton function: f(", f4, ") = ", myFunc(f4));

fprintf("convergence\n");
fprintf("%s %i \n","Bisection: ",convergence(error1));
fprintf("%s %i \n","Newton: ",convergence(error2));
fprintf("%s %i \n","Secant: ",convergence(error3));
fprintf("%s %i \n","Modified Newton: ",convergence(error4));
%I do not know why it quadractic converges for secant and bisection

%the limit function from 
function out = convergence(error)
    con = zeros(length(error)-2, 1);
    for n = 2:length(con)
        con(n) = log(error(n+2)/error(n+1))/log(error(n+1)/error(n));
    end
    con(isinf(con)|isnan(con)) = 0;
    alpha = max(con, [], 'all');
    out = int8(alpha);
end

function [x,f] = bisection(n,x,a,b)

    for i=1:n
        %find mid point
       c = a + (b-a)/2;
       x(i)=c;
       if myFunc(c) > 0
           b=c;
       elseif myFunc(c) < 0
           a=c;
       else
           break
       end
    end
    f=c;
end

function [x,f] = newton(n,x,p)  
    for i=1:n
    p = p - (myFunc(p)/myD1Func(p));
    x(i)=p;
    end
    f=p;
end

function [x,f] = secant(n,p0,p1,x,p2)
    for i=1:n
       p2 = secantFunc(p0,p1); 
       x(i)=p2;
       p0=p1;
       p1=p2;
       if myFunc(p2) == 0
           break;
       end
    end
    f=p2;
end

function out = secantFunc(p0,p1)
    num=(p1-p0)*(myFunc(p1));
        denom=(myFunc(p1)-myFunc(p0));
    out=p1-(num/denom);
end

function [x,f] = FuncModifiedNewton(n,x,p)
for i=1:n
       p=ModifiedNewton(p);
       x(i)=p;
       if myFunc(p) == 0
           break;
       end
end
f=p;
end

%modified newton from page 83
function out = ModifiedNewton(c) 
    num = myFunc(c)*myD1Func(c);
    denom = (myD1Func(c)^2)-(myFunc(c)*myD2Func(c));
    out = c-(num/denom);
%     fprintf('modified Newton method');
%     fprintf('The Root is : %f \n',out);
end

%this is the function, it's the same besides shrinked
%if expanded, it will be the same
function out = myFunc(x)
    out = (x-.5)^3*(x+exp(x));
end

%first derivative function
function out = myD1Func(x)
    %out = diff(myFunc(x));
     out = (x-.5)^3*(1+exp(x)) + 3*(x-.5)^2*(x+exp(x));
end

%second derivative function
function out = myD2Func(x)

    %out = diff(myFunc(x,2));
     out = exp(x)*(x-.5)^3*exp(x) + 6*(x-.5)*(exp(x)+x) + 6*(x-.5)^2*(1+exp(x));
end