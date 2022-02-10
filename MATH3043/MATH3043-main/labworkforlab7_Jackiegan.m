x=100;

%diag(v), diag(v,1) look into this function, look into a diagonal function
v = 10*ones(x,1);
u = 2*ones(x-1,1);
% u1 = 2*ones(x-1,1);
b = 1*ones(x,1);

%initial guess
x0 = 0*ones(x,1);


%iterations
n = 100;

%problem with matlab, not the correct matrix size
A = diag(u,1) + diag(u,-1)+diag(v);


%  disp(A);

[L,U]=lowerUpper(A);
%  disp(L);
%  disp(U);

disp("LU method");
x = solveLU(L,U,b);
disp(x);

disp("Jacobi iteration method");
x1 = Jacobi(A,b,n,x0);
disp(x1);

disp("Gauss-Seidel method");
x2 = Seidel(A,b,n,x0);
disp(x2);


%page 406 textbook
function [L,U] = lowerUpper(A)
% L is the lower triange matrix
% U is the upper triangle matrix
% A is the matrix input
% to get LU both the matrix must be squared
 [d1,d2]=size(A);

    %checking if it's a square matrix
    if d1 ~= d2
        disp("Factorization impossible");
        return
    end
    
    for j = 1:d1
         i = j+1:d1;
            A(i,j) = A(i,j)/A(j,j);
            A(i,i) = A(i,i)-A(i,j)*A(j,i);
    end
    L = tril(A,-1)+eye(d1);
    U = triu(A);
end

function x = solveLU(L,U,B)
    %LY = B
    %UX = Y
    temp = inv(L)*B;
    x = inv(U)*temp;
end

%page 456 textbook
function x = Jacobi(A,b,N,x0)
    %D-L-U
    %A is the matrix, n the iteration, x0 initial vector
    
    L = tril(A,-1);
    U = triu(A,1);
    D = diag(diag(A));
    
    
        x = inv(D)*(b-(L+U)*x0);
        for j=1:N
            x = inv(D)*(b-(L+U)*x);
        end
end

%page 456 textbook
function x = Seidel(A,b,N,x0)
    L = tril(A,-1);
    U = triu(A,1);
    D = diag(diag(A));
    
    x = -(inv(D+L)*U*x0)+inv(D+L)*b;
    for j=1:N
        x = -(inv(D+L)*U*x)+inv(D+L)*b;
    end
end


