import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
import numpy as np

data = np.genfromtxt('result.csv', delimiter=',', dtype=str)

# convert to float, replacing '&' with NaN
x = np.array([float(val[1:]) if val.startswith('&') else float(val) for val in data[:, 0]])
y = np.array([float(val[1:]) if val.startswith('&') else float(val) for val in data[:, 1]])
z = np.array([float(val[1:]) if val.startswith('&') else float(val) for val in data[:, 2]])

# flag for ampersand marked for different coloring
is_different_color = np.array([val.startswith('&') for val in data[:, 0]])

# plot
fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')
ax.scatter(x[~is_different_color], y[~is_different_color], z[~is_different_color], color='b')
ax.scatter(x[is_different_color], y[is_different_color], z[is_different_color], color='r')
plt.show()
