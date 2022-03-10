%Jackie Gan
%Numerical Analysis 2, Math 3044
%Professor Guan
format long

%H values, mesh size(just uncomment the needed meshsize)
%a)
%h = pi/4;
%b)
%h = pi/8;
%given from hw
h = pi/32;

% initial value
xmin = 0;
xmax = pi/2;
alpha = -0.3;
beta = -0.1;
N = (xmax-xmin)/h;
 
%actual function to check errors
Freal = @(x)((-1/10)*(sin(x)+3*cos(x)));

%y"(x) = p(x)y'(x) + q(x)y(x) + r(x)
%ODE: y"=y'+2y+cosx
p = @(x) (1);  
q = @(x) (2);
r = @(x) (cos(x));

% initalize vector for mesh
fprintf('   xi           wi           y(xi)      absolute error   \n');
a = zeros(1,N+1);
b = zeros(1,N+1);
c = zeros(1,N+1);
d = zeros(1,N+1);
%step 1
x = xmin+h;
a(1) = 2+h^2*q(x);
b(1) = -1+0.5*h*p(x);
d(1) = -h^2*r(x)+(1+0.5*h*p(x))*alpha;
n = N-1;

%step 2
    for i = 2 : n 
        x = xmin+i*h;
        a(i) = 2+h^2*q(x);
        b(i) = -1+0.5*h*p(x);
        c(i) = -1-0.5*h*p(x);
        d(i) = -h^2*r(x);
    end

%initialize vector for new mesh
l = zeros(1,N+1);
u = zeros(1,N+1);
z = zeros(1,N+1);
%step 3
x = xmax-h;
a(N) = 2+h^2*q(x);
c(N) = -1-0.5*h*p(x);
d(N) = -h^2*r(x)+(1-0.5*h*p(x))*beta;

%step 4
l(1) = a(1);
u(1) = b(1)/a(1);
z(1) = d(1)/l(1);

%step 5
    for i = 2 : n 
        l(i) = a(i)-c(i)*u(i-1);
        u(i) = b(i)/l(i);
        z(i) = (d(i)-c(i)*z(i-1))/l(i);
    end

%step 6
%w is the full computation
w = zeros(1,N+1);
l(N) = a(N)-c(N)*u(N-1);
z(N) = (d(N)-c(N)*z(N-1))/l(N);
w(N) = z(N);

%step 8
for j = 1 : n 
    i = N-j;
    w(i) = z(i)-u(i)*w(i+1);
end

Fp = zeros(1,N+1);

%this i is for initial starting point of 0
i = xmin;
fprintf('%5.4f    %11.8f    %11.8f    %5.4e\n', xmin, alpha, Freal(xmin), abs(Freal(xmin)-alpha));

%step 9
    for i = 1 : N 
        x = xmin+i*h;
        fprintf('%5.4f    %11.8f    %11.8f    %5.4e\n', x, w(i), Freal(x), abs(Freal(x)-w(i)));
        Fp(i) = Freal(x);
    end
i = N+1;
fprintf('%5.4f    %11.8f    %11.8f    %5.4e\n', xmax, beta, Freal(xmax), abs(Freal(xmax)-beta));
Fp(i) = Freal(xmax);
%this is the plot
plot(Fp)
hold on
plot(w)