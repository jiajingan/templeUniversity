%Jackie Gan
%Numerical Analysis 2, Math 3044
%Professor Guan
format long

close all
clear
clc

a = 0; b = 1; c = 0; d = 1;
h = 0.2;
%m and n are the mesh size of the grid
n = (b-a)/h; m = (d-c)/h; 
%let tolerance be 1*10^-8 and 50 iterations
TOL = 1e-8;
N = 41;
%after a couple trial and errors, N>40 to converge
%41 iterations is needed to converge. 
w = poisson(a, b, c, d, m, n, TOL, N);
disp(w)


function w = poisson(a, b, c, d, m, n, TOL, N)

h = (b-a)/n;
k = (d-c)/m;
  
x = []; y = [];
for i = 1:n-1
    x = [x, a + i*h];
end

for j = 1:m-1
    y = [y, c + j*k];
end
w = zeros(n-1, m-1);
  

lambda = h^2 / k^2;
mu = 2*(1 + lambda);
l = 1;
  

while l <= N

    z = (-h^2*f(x(1), y(m-1)) + g(a, y(m-1)) + lambda*g(x(1), d) + lambda*w(1, m-2) + lambda*w(2, m-1)) / mu;
    norm1 = norm(z - w(1, m-1));
    w(1, m-1) = z;
      

    for i = 2:n-2
        z = (-h^2*f(x(i),y(m-1)) + lambda*g(x(i), d) + w(i-1, m-1) + w(i+1, m-1) + lambda*w(i, m-2)) / mu;
        normTemp = norm(w(i, m-1) - z);
        if normTemp > norm1
            norm1 = normTemp;
        end
        w(i, m-1) = z;
    end
      

    z = (-h^2*f(x(n-1), y(m-1)) + g(b, y(m-1)) + lambda*g(x(n-1), d) + w(n-2, m-1) + lambda*w(n-1, m-2)) / mu;
    normTemp = norm(w(n-1, m-1) - z);
    if normTemp > norm1
        norm1 = normTemp;
    end
    w(n-1, m-1) = z;
      

    for j = m-2:-1:2

        z = (-h^2*f(x(1), y(j)) + g(a, y(j)) + lambda*w(1, j+1) + lambda*w(1, j-1) + w(2, j)) / mu;
        normTemp = norm(w(1, j) - z);

        if normTemp > norm1
            norm1 = normTemp;
        end
        w(1, j) = z;

        for i = 2:n-2
        z = (-h^2*f(x(i), y(j)) + w(i-1, j) + lambda*w(i, j+1) + w(i+1, j) + lambda*w(i, j-1)) / mu;
        normTemp = norm(w(i, j) - z);
            if normTemp > norm1
                norm1 = normTemp;
            end
        w(i, j) = z;
        end
          
        z = (-h^2*f(x(n-1), y(j)) + g(b, y(j)) + w(n-2, j) + lambda*w(n-1, j+1) + lambda*w(n-1, j-1)) / mu;
        normTemp = norm(w(n-1, j) - z);

        if normTemp > norm1
            norm1 = normTemp;
        end
        w(n-1, j) = z;
    end
      

    z = (-h^2*f(x(1), y(1)) + g(a, y(1)) + lambda*g(x(1), c) + lambda*w(1, 2) + w(2, 1)) / mu;
    normTemp = norm(w(1, 1) - z);
    if normTemp > norm1
    norm1 = normTemp;
    end
    w(1, 1) = z;
      
    for i = 2:n-2
        z = (-h^2*f(x(i), y(1)) + lambda*g(x(i), c) + w(i-1, 1) + lambda*w(i, 2) + w(i+1, 1)) / mu;
        normTemp = norm(w(i, 1) - z);
        if normTemp > norm1
            norm1 = normTemp;
        end
        w(i, 1) = z;
    end
      

    z = (-h^2*f(x(n-1), y(1)) + g(b, y(1)) + lambda*g(x(n-1), c) + w(n-2, 1) + lambda*w(n-1, 2)) / mu;
    normTemp = norm(w(n-1, 1) - z);
        if normTemp > norm1
            norm1 = normTemp;
        end
    w(n-1, 1) = z;
      

    if norm1 <= TOL
        %return when you reached the limit
    return
    end

    l = l + 1;
end
disp('Maximum number of iterations exceeded.')
end

%the x and y functions that are outputting the values
function out = f(x, y)
    out = 0;
end

function out = g(x, y)
    if (y == 0) || (x == 0)
        out = 0;
    elseif y == 1
        out = x;
    elseif x == 1
        out = y;
    end
end
