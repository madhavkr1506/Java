from sklearn.datasets import make_classification
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense 
from sklearn.model_selection import train_test_split

x, y = make_classification(n_samples = 1000, n_features = 20, n_classes = 2, random_state = 42)

print(x.shape)
print(y.shape)


x_train, x_test, y_train, y_test = train_test_split(x, y, test_size = 0.2, random_state = 42)

# print(x_train.shape)

model = Sequential()

model.add(Dense(units = 64, activation = "relu", input_shape = (20,)))

model.add(Dense(units = 32, activation = "relu"))

model.add(Dense(units = 1, activation = "sigmoid"))


model.compile(optimizer = "adam",loss = "binary_crossentropy", metrics = ["accuracy"])

model.fit(x_train, y_train, epochs = 10, batch_size = 32, validation_split = 0.2)

loss, accuracy = model.evaluate(x_test, y_test)

print(f"loss : {loss}")
print(f"accuracy : {accuracy}")


prediction = model.predict(x_test)
prediction = (prediction > 0.5).astype(int)
print(prediction[:10])