import hashlib
import random
from datetime import datetime
from math import *


#hashing algorithm
def hash1(msg):
    hash_object = hashlib.sha256(msg.encode('utf-8'))
    hex_dig = hash_object.hexdigest()
    return hex_dig

#generate hash cash
def generateCash(include, numOfZeros):
    loop = True
    counter = 0
    random.seed(datetime.now())
    x = str(random.randint(1,1180591620717411303424))
    while(loop):
        counter = counter + 1
        solution = True
        testHash = hash1(include + ":" + x + ":" + str(counter))

        for i in range(0, numOfZeros):
            if(testHash[i] != "0"):
                solution = False
                break
        
        if(solution == True):
            loop = False
        
    print("")
    print("value (ProofOfWork):")
    print("")
    print(include + ":" + x + ":" + str(counter))
    print("")
    print("hash (Verification):")
    print("")
    print(hash1(include + ":" + x + ":" + str(counter)))
    print("")
    print("")
    print("it took me "+"{:,}".format(counter)+" hashes to figure this out")

#custom input 
generateCash("mushtaq",2)


# it gives a brief understanding of how proof of Work takes place
# if the number of zeros is greater than 6 it will take a very long time to generate the desired result
