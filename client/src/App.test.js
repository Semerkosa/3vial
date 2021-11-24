import { render, fireEvent, screen } from '@testing-library/react';
import App from './App';

// DRY - don't repeat yourself - principle
// DAMP - descriptive and meaningful phrases - principle

test('Profile link is visible on page load', () => {
  render(<App />);
  const linkElement = screen.getByText(/Profile/);

  expect(linkElement).toBeInTheDocument();
});

test('Bank option is not visible on page load', () => {
  render(<App />);

  expect(() => {screen.getByText(/Bank/)}).toThrow();
});

test('Bank option is visible when Profile link is clicked', () => {
    render(<App />);
    const linkElement = screen.getByText(/Profile/);
    linkElement.click();

    const bankOptionElement = screen.getByText(/Bank/);

    expect(bankOptionElement).toBeInTheDocument();
});

test('Selecting bank option shows "select country" label', () => {
    render(<App />);
    const linkElement = screen.getByText(/Profile/);
    linkElement.click();
    const dropDownElement = screen.getByTestId("source-type-select");

    fireEvent.change(dropDownElement, { target: { value: "Bank" }});

    const bankOptionElement = screen.getByText("Bank");

    expect(bankOptionElement.selected).toBeTruthy();

    const selectCountryLabel = screen.getByText(/Select country.../);
});