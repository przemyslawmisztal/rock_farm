Hobbit units calculator
=========

Simple but useful Android application that calculates amount of T1 troops to train while making sure your available resources are spent the best efficient way. In result you will be able to queue more units.

## Quick start

1. Allow application installs from “unknown sources” (http://developer.android.com/distribute/tools/open-distribution.html#unknown-sources).
2. Download APK on your PC and copy them to your phone, or download directly from your phone.
3. Install APK with the file manager.

## Usage

Enter amount for each of the resources that you have. As in game resource quantities are rather large app takes that units are in thousands. So if you have one million of food just type 1000. When you done just press OK to see how much units you should buy to use the most of your resources.

## How does it work?

Application uses [Simplex algorithm] (http://en.wikipedia.org/wiki/Simplex_algorithm) to determine best way to queue units. The goal is to maximize amount of might produced with limited resources. Balanced spread of unit types is not taken into consideration.

## Bugs and feature requests

Have a bug or a feature request? [Please open a new issue](https://github.com/rocktail/rock_farm/issues/new).

####Licensing

Software is released under the GNU General Public License, version 3 (GPLv3) (http://www.gnu.org/copyleft/gpl.html).

Credit for simplex algorithm goes to http://algs4.cs.princeton.edu/.
