clear;
clc;
close all;

%grid points, global values
x0=-1;
x1=0;
x2=1;
y0 = myFunc(x0);
y1 = myFunc(x1);
y2 = myFunc(x2);
x = [x0 x1 x2];
y = [y0 y1 y2];
disp(y);

yd0 = dmyFunc(x0);
yd1 = dmyFunc(x1);
yd2 = dmyFunc(x2);

% %Lagrange 
% yl0 = Lagrange(x,y,x0);
% yl1 = Lagrange(x,y,x1);
% yl2 = Lagrange(x,y,x2);
% yl=[yl0 yl1 yl2];
% disp(yl);

%hermite
yh0 = Hermite(x0);
yh1 = Hermite(x1);
yh2 = Hermite(x2);
yh = [yh0 yh1 yh2];
disp(yh);

%cubic spline
% yc0 = Cubic(x,y,1);
% yc1 = Cubic(x,y,2);
% yc2 = Cubic(x,y,3);
% yc = [yc0 yc1 yc2];
% disp(yc);

%lx and dlx vector
% lx  =[l0(x,x0) l1(x,x0) l2(x,x0)];
% dlx =[];

% check = getployl0(x,x0);
% disp(check);

hold on 
title('1/(1+(25*(x^2)))');
xlabel('x');
ylabel('y');
%plot(x,y,'r')
fplot(@(x) myFunc(x),[-1,1],'m')
fplot(@(x) Lagrange(x),[-1,1],'y')
fplot(@(x) Hermite(x),[-1,1],'c')
fplot(@(x) Cubic2(x),[-1,1],'r')

%fplot(@(x) ,[-1,1],'b')
%fplot(@(x) myFunc(x),[-1,1],'b')
%fplot(@(x) Lagrange(x,y,x0),[-1,1],'b');
%flplot(@(x) Hermite,[-1,1],'r')
%flplot(@(x) Cubic,[-1,1],'r')


hold off
grid on

fprintf("results\n");
%fprintf("%s %.10f\n","Lagrange", Lagrange(x,y));
%fprintf("%s %.10f %s %.10f \n", "Lagrange", f2, ") = ", myFunc(f2));

%no idea how to do it, did it by hand not sure
function out = Cubic2(x)
%     out = spline(x(n),y(n));
    out = (x^3*(1/4.8075))-(1.4423*(x^2))+1;
end

% 
% function out = Hermite(x,y,xi)
% 
%     out = (y(1)*(1-2*(xi-x(1)))*(dl0(xi))*(l0(x,xi)^2)) + ...
%         (dmyFunc(xi)*(xi-x(1))*(l0(x,xi)^2)) +...
%         (y(2)*(1-2*(xi-x(2)))*(dl1(xi))*(l1(x,xi)^2)) + ...
%         (dmyFunc(xi)*(xi-x(2))*(l1(x,xi)^2)) + ...
%         (y(3)*(1-2*(xi-x(3)))*(dl2(xi))*(l2(x,xi)^2)) + ...
%         (dmyFunc(xi)*(xi-x(3))*(l2(x,xi)^2));
%     
% end


%I did the equation by hand and plot it, using difference chart to solve
function out = Hermite(x)
out = 1+(1.923*x)+(0.9615*x^2);
end


function out = Lagrange(xi)
    x=[-1 0 1];
    y=[0.0385 1.0000 0.0385];
    out = (y(1)*l0(x,xi))+(y(2)*l1(x,xi))+(y(3)*l2(x,xi));
end


% function f = getployl0(x,xi)
%     function out = l0(x,xi)
%         out = ((xi-x(2))*(xi-x(3)))/((x(1)-x(2))*(x(1)-x(3)));
%     end
%     f = @l0;
% end

function out = l0(x,xi)
    out = ((xi-x(2))*(xi-x(3)))/((x(1)-x(2))*(x(1)-x(3)));
end

function out = l1(x,xi)
    out = ((xi-x(1))*(xi-x(3)))/((x(2)-x(1))*(x(2)-x(3)));
end

function out = l2(x,xi)
    out = ((xi-x(1))*(xi-x(2)))/((x(3)-x(1))*(x(3)-x(2)));
end

function out = dl0(x)
    out = x-0.5;
end

function out = dl1(x)
    out = -2*x;
end

function out = dl2(x)
    out = x+0.5;
end

function out = myFunc(x)
    out = 1/(1+(25*(x^2)));
    
end

function out = dmyFunc(x)
    out = (-50*x)/(((25*(x^2))+1)^2);
end