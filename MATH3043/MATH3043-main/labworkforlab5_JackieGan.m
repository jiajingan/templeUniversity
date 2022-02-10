% %initialize the values
h=[1/4 1/8 1/16 1/32];
x=1;
f=exp(x);
[z1 ,z2 ,z3,z4,z5,z6,z7]=convergence(f,h,x);


%test cases
% z1
% z2
% z3
% z4
% z5
% z6
% z7

hold off
plot(h,z1);
hold on
plot(h,z2);
hold on
plot(h,z3);
hold on

plot(h,z4);
hold on

plot(h,z5);
hold on
plot(h,z6);
hold on
plot(h,z7);
hold on
%note: the results from simpson's rule and midpoint rule are very similar,
%this is why it won't show up on the graph, they overlap

legend('backward difference', 'Three-point endpoint', 'three-point midpoint','Second derivative midpoint','trapzoidal rule','simpsons rule','midpoint rule');


function [finalBack,finalEnd,finalMid,finalSmid,finaltrapz,finalsims,finalmidp] = convergence(f,h,x)
%f is the function
%h is the vector of h values for convergence
%x is the value for 

% x=1;
backDiff = 0*h;
Tendpoint = 0*h;
Tmidpoint = 0*h;
secondmid = 0*h;

trapz = 0*h;
sims = 0*h;
midp = 0*h;

% f=exp(x);
    for i=1:length(h)
        %backward difference
        backDiff(i)=(exp(x)-exp(x-h(i)))/h(i);
        %three endpoint
        Tendpoint(i) = ((-3*exp(x))+(4*(exp(x+h(i))))-(exp(x+(2*h(i)))))/(2*h(i));
        %three midpoint
        Tmidpoint(i) = (exp(x+h(i))-exp(x-h(i)))/(2*h(i));
        %second derivative midpoint
        secondmid(i) = (exp(x-h(i))-(2*exp(x))+exp(x+h(i)))/(h(i)^2);
        
        %trapzoidal rule
        trapz(i) = (h(i)/2)*(exp(0)+exp(h(i)));
        %simpson's rule
        sims(i) = (h(i)/3)*(exp(0)+(4*exp(h(i)/2))+exp(h(i)));
        %midpoint rule
        midp(i) = (2*h(i))*(exp(h(i)/2));
    end
    
finalBack = abs(backDiff-f);
finalEnd = abs(Tendpoint-f);
finalMid = abs(Tmidpoint-f);
finalSmid = abs(secondmid-f);

finaltrapz = abs(trapz-f);
finalsims = abs(sims-f);
finalmidp = abs(midp-f);

end