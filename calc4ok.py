import sys
from PyQt5.QtCore import Qt
from PyQt5.QtWidgets import QApplication, QWidget, QVBoxLayout, QHBoxLayout, QLineEdit, QPushButton

class Calculator(QWidget):
    def __init__(self):
        super().__init__()

        # Set up the UI
        self.setWindowTitle(' Simple Calculator')
        self.setGeometry(100, 100, 300, 200)
        self.display = QLineEdit(self)
        self.display.setReadOnly(True)
        self.display.setAlignment(Qt.AlignRight)
        self.layout = QVBoxLayout()
        self.layout.addWidget(self.display)

        # Create buttons
        buttons = [
            ['7', '8', '9', '/'],
            ['4', '5', '6', '*'],
            ['1', '2', '3', '-'],
            ['0', '.', '=', '+'],
            ['C', 'Backspace']
        ]
        for row in buttons:
            h_layout = QHBoxLayout()
            for label in row:
                button = QPushButton(label)
                button.clicked.connect(self.handle_button)
                h_layout.addWidget(button)
            self.layout.addLayout(h_layout)

        self.setLayout(self.layout)

    def handle_button(self):
        button = self.sender()
        if button.text() == '=':
            # Evaluate the expression
            try:
                result = str(eval(self.display.text()))
            except:
                result = 'Error'
            self.display.setText(result)
        elif button.text() == 'C':
            # Clear the display
            self.display.setText('')
        elif button.text() == 'Backspace':
            # Delete the newest character
            text = self.display.text()[:-1]
            self.display.setText(text)
        else:
            # Append the digit/operator to the display
            text = self.display.text() + button.text()
            self.display.setText(text)
            
if __name__ == '__main__':
    app = QApplication(sys.argv)
    calc = Calculator()
    calc.show()
    sys.exit(app.exec_())
